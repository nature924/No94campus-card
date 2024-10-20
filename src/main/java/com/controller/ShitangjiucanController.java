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

import com.entity.ShitangjiucanEntity;
import com.entity.view.ShitangjiucanView;

import com.service.ShitangjiucanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 食堂就餐
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@RestController
@RequestMapping("/shitangjiucan")
public class ShitangjiucanController {
    @Autowired
    private ShitangjiucanService shitangjiucanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShitangjiucanEntity shitangjiucan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shitangjiucan.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();

		PageUtils page = shitangjiucanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shitangjiucan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShitangjiucanEntity shitangjiucan, 
		HttpServletRequest request){
        EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();

		PageUtils page = shitangjiucanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shitangjiucan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShitangjiucanEntity shitangjiucan){
       	EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shitangjiucan, "shitangjiucan")); 
        return R.ok().put("data", shitangjiucanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShitangjiucanEntity shitangjiucan){
        EntityWrapper< ShitangjiucanEntity> ew = new EntityWrapper< ShitangjiucanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shitangjiucan, "shitangjiucan")); 
		ShitangjiucanView shitangjiucanView =  shitangjiucanService.selectView(ew);
		return R.ok("查询食堂就餐成功").put("data", shitangjiucanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShitangjiucanEntity shitangjiucan = shitangjiucanService.selectById(id);
        return R.ok().put("data", shitangjiucan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShitangjiucanEntity shitangjiucan = shitangjiucanService.selectById(id);
        return R.ok().put("data", shitangjiucan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShitangjiucanEntity shitangjiucan, HttpServletRequest request){
    	shitangjiucan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shitangjiucan);
        shitangjiucanService.insert(shitangjiucan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShitangjiucanEntity shitangjiucan, HttpServletRequest request){
    	shitangjiucan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shitangjiucan);
        shitangjiucanService.insert(shitangjiucan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShitangjiucanEntity shitangjiucan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shitangjiucan);
        shitangjiucanService.updateById(shitangjiucan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shitangjiucanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = shitangjiucanService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = shitangjiucanService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = shitangjiucanService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = shitangjiucanService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ShitangjiucanEntity> ew = new EntityWrapper<ShitangjiucanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = shitangjiucanService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }






}
