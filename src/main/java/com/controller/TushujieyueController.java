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

import com.entity.TushujieyueEntity;
import com.entity.view.TushujieyueView;

import com.service.TushujieyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书借阅
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@RestController
@RequestMapping("/tushujieyue")
public class TushujieyueController {
    @Autowired
    private TushujieyueService tushujieyueService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushujieyueEntity tushujieyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			tushujieyue.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TushujieyueEntity> ew = new EntityWrapper<TushujieyueEntity>();

		PageUtils page = tushujieyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushujieyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushujieyueEntity tushujieyue, 
		HttpServletRequest request){
        EntityWrapper<TushujieyueEntity> ew = new EntityWrapper<TushujieyueEntity>();

		PageUtils page = tushujieyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushujieyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushujieyueEntity tushujieyue){
       	EntityWrapper<TushujieyueEntity> ew = new EntityWrapper<TushujieyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushujieyue, "tushujieyue")); 
        return R.ok().put("data", tushujieyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushujieyueEntity tushujieyue){
        EntityWrapper< TushujieyueEntity> ew = new EntityWrapper< TushujieyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushujieyue, "tushujieyue")); 
		TushujieyueView tushujieyueView =  tushujieyueService.selectView(ew);
		return R.ok("查询图书借阅成功").put("data", tushujieyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushujieyueEntity tushujieyue = tushujieyueService.selectById(id);
        return R.ok().put("data", tushujieyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushujieyueEntity tushujieyue = tushujieyueService.selectById(id);
        return R.ok().put("data", tushujieyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushujieyueEntity tushujieyue, HttpServletRequest request){
    	tushujieyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushujieyue);
        tushujieyueService.insert(tushujieyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushujieyueEntity tushujieyue, HttpServletRequest request){
    	tushujieyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushujieyue);
        tushujieyueService.insert(tushujieyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushujieyueEntity tushujieyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushujieyue);
        tushujieyueService.updateById(tushujieyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TushujieyueEntity> list = new ArrayList<TushujieyueEntity>();
        for(Long id : ids) {
            TushujieyueEntity tushujieyue = tushujieyueService.selectById(id);
            tushujieyue.setSfsh(sfsh);
            tushujieyue.setShhf(shhf);
            list.add(tushujieyue);
        }
        tushujieyueService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushujieyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
