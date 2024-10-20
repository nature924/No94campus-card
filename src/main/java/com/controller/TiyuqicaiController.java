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

import com.entity.TiyuqicaiEntity;
import com.entity.view.TiyuqicaiView;

import com.service.TiyuqicaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 体育器材
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@RestController
@RequestMapping("/tiyuqicai")
public class TiyuqicaiController {
    @Autowired
    private TiyuqicaiService tiyuqicaiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TiyuqicaiEntity tiyuqicai,
		HttpServletRequest request){
        EntityWrapper<TiyuqicaiEntity> ew = new EntityWrapper<TiyuqicaiEntity>();

		PageUtils page = tiyuqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiyuqicai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TiyuqicaiEntity tiyuqicai, 
		HttpServletRequest request){
        EntityWrapper<TiyuqicaiEntity> ew = new EntityWrapper<TiyuqicaiEntity>();

		PageUtils page = tiyuqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiyuqicai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TiyuqicaiEntity tiyuqicai){
       	EntityWrapper<TiyuqicaiEntity> ew = new EntityWrapper<TiyuqicaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tiyuqicai, "tiyuqicai")); 
        return R.ok().put("data", tiyuqicaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TiyuqicaiEntity tiyuqicai){
        EntityWrapper< TiyuqicaiEntity> ew = new EntityWrapper< TiyuqicaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tiyuqicai, "tiyuqicai")); 
		TiyuqicaiView tiyuqicaiView =  tiyuqicaiService.selectView(ew);
		return R.ok("查询体育器材成功").put("data", tiyuqicaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TiyuqicaiEntity tiyuqicai = tiyuqicaiService.selectById(id);
        return R.ok().put("data", tiyuqicai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TiyuqicaiEntity tiyuqicai = tiyuqicaiService.selectById(id);
        return R.ok().put("data", tiyuqicai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TiyuqicaiEntity tiyuqicai, HttpServletRequest request){
    	tiyuqicai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tiyuqicai);
        tiyuqicaiService.insert(tiyuqicai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TiyuqicaiEntity tiyuqicai, HttpServletRequest request){
    	tiyuqicai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tiyuqicai);
        tiyuqicaiService.insert(tiyuqicai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TiyuqicaiEntity tiyuqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tiyuqicai);
        tiyuqicaiService.updateById(tiyuqicai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tiyuqicaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
