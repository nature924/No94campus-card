package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShangjijiluEntity;
import com.entity.view.ShangjijiluView;

import com.service.ShangjijiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 上机记录
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
@RestController
@RequestMapping("/shangjijilu")
public class ShangjijiluController {
    @Autowired
    private ShangjijiluService shangjijiluService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangjijiluEntity shangjijilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shangjijilu.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangjijiluEntity> ew = new EntityWrapper<ShangjijiluEntity>();

		PageUtils page = shangjijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangjijilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangjijiluEntity shangjijilu, 
		HttpServletRequest request){
        EntityWrapper<ShangjijiluEntity> ew = new EntityWrapper<ShangjijiluEntity>();

		PageUtils page = shangjijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangjijilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangjijiluEntity shangjijilu){
       	EntityWrapper<ShangjijiluEntity> ew = new EntityWrapper<ShangjijiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangjijilu, "shangjijilu")); 
        return R.ok().put("data", shangjijiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangjijiluEntity shangjijilu){
        EntityWrapper< ShangjijiluEntity> ew = new EntityWrapper< ShangjijiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangjijilu, "shangjijilu")); 
		ShangjijiluView shangjijiluView =  shangjijiluService.selectView(ew);
		return R.ok("查询上机记录成功").put("data", shangjijiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangjijiluEntity shangjijilu = shangjijiluService.selectById(id);
        return R.ok().put("data", shangjijilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangjijiluEntity shangjijilu = shangjijiluService.selectById(id);
        return R.ok().put("data", shangjijilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangjijiluEntity shangjijilu, HttpServletRequest request){
    	shangjijilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangjijilu);
        shangjijiluService.insert(shangjijilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangjijiluEntity shangjijilu, HttpServletRequest request){
    	shangjijilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangjijilu);
        shangjijiluService.insert(shangjijilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShangjijiluEntity shangjijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangjijilu);
        shangjijiluService.updateById(shangjijilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangjijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
