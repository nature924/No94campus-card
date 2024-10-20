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

import com.entity.YikatongEntity;
import com.entity.view.YikatongView;

import com.service.YikatongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 一卡通
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@RestController
@RequestMapping("/yikatong")
public class YikatongController {
    @Autowired
    private YikatongService yikatongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YikatongEntity yikatong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			yikatong.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YikatongEntity> ew = new EntityWrapper<YikatongEntity>();

		PageUtils page = yikatongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yikatong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YikatongEntity yikatong, 
		HttpServletRequest request){
        EntityWrapper<YikatongEntity> ew = new EntityWrapper<YikatongEntity>();

		PageUtils page = yikatongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yikatong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YikatongEntity yikatong){
       	EntityWrapper<YikatongEntity> ew = new EntityWrapper<YikatongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yikatong, "yikatong")); 
        return R.ok().put("data", yikatongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YikatongEntity yikatong){
        EntityWrapper< YikatongEntity> ew = new EntityWrapper< YikatongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yikatong, "yikatong")); 
		YikatongView yikatongView =  yikatongService.selectView(ew);
		return R.ok("查询一卡通成功").put("data", yikatongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YikatongEntity yikatong = yikatongService.selectById(id);
        return R.ok().put("data", yikatong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YikatongEntity yikatong = yikatongService.selectById(id);
        return R.ok().put("data", yikatong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YikatongEntity yikatong, HttpServletRequest request){
    	yikatong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yikatong);
        yikatongService.insert(yikatong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YikatongEntity yikatong, HttpServletRequest request){
    	yikatong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yikatong);
        yikatongService.insert(yikatong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YikatongEntity yikatong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yikatong);
        yikatongService.updateById(yikatong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YikatongEntity> list = new ArrayList<YikatongEntity>();
        for(Long id : ids) {
            YikatongEntity yikatong = yikatongService.selectById(id);
            yikatong.setSfsh(sfsh);
            yikatong.setShhf(shhf);
            list.add(yikatong);
        }
        yikatongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yikatongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
