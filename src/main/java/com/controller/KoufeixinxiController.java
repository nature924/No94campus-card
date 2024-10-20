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

import com.entity.KoufeixinxiEntity;
import com.entity.view.KoufeixinxiView;

import com.service.KoufeixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 扣费信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@RestController
@RequestMapping("/koufeixinxi")
public class KoufeixinxiController {
    @Autowired
    private KoufeixinxiService koufeixinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KoufeixinxiEntity koufeixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			koufeixinxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KoufeixinxiEntity> ew = new EntityWrapper<KoufeixinxiEntity>();

		PageUtils page = koufeixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, koufeixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KoufeixinxiEntity koufeixinxi, 
		HttpServletRequest request){
        EntityWrapper<KoufeixinxiEntity> ew = new EntityWrapper<KoufeixinxiEntity>();

		PageUtils page = koufeixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, koufeixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KoufeixinxiEntity koufeixinxi){
       	EntityWrapper<KoufeixinxiEntity> ew = new EntityWrapper<KoufeixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( koufeixinxi, "koufeixinxi")); 
        return R.ok().put("data", koufeixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KoufeixinxiEntity koufeixinxi){
        EntityWrapper< KoufeixinxiEntity> ew = new EntityWrapper< KoufeixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( koufeixinxi, "koufeixinxi")); 
		KoufeixinxiView koufeixinxiView =  koufeixinxiService.selectView(ew);
		return R.ok("查询扣费信息成功").put("data", koufeixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KoufeixinxiEntity koufeixinxi = koufeixinxiService.selectById(id);
        return R.ok().put("data", koufeixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KoufeixinxiEntity koufeixinxi = koufeixinxiService.selectById(id);
        return R.ok().put("data", koufeixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KoufeixinxiEntity koufeixinxi, HttpServletRequest request){
    	koufeixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(koufeixinxi);
        koufeixinxiService.insert(koufeixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KoufeixinxiEntity koufeixinxi, HttpServletRequest request){
    	koufeixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(koufeixinxi);
        koufeixinxiService.insert(koufeixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KoufeixinxiEntity koufeixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(koufeixinxi);
        koufeixinxiService.updateById(koufeixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        koufeixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
