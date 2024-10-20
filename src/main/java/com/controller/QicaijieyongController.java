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

import com.entity.QicaijieyongEntity;
import com.entity.view.QicaijieyongView;

import com.service.QicaijieyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 器材借用
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@RestController
@RequestMapping("/qicaijieyong")
public class QicaijieyongController {
    @Autowired
    private QicaijieyongService qicaijieyongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QicaijieyongEntity qicaijieyong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			qicaijieyong.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QicaijieyongEntity> ew = new EntityWrapper<QicaijieyongEntity>();

		PageUtils page = qicaijieyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaijieyong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QicaijieyongEntity qicaijieyong, 
		HttpServletRequest request){
        EntityWrapper<QicaijieyongEntity> ew = new EntityWrapper<QicaijieyongEntity>();

		PageUtils page = qicaijieyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaijieyong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QicaijieyongEntity qicaijieyong){
       	EntityWrapper<QicaijieyongEntity> ew = new EntityWrapper<QicaijieyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qicaijieyong, "qicaijieyong")); 
        return R.ok().put("data", qicaijieyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QicaijieyongEntity qicaijieyong){
        EntityWrapper< QicaijieyongEntity> ew = new EntityWrapper< QicaijieyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qicaijieyong, "qicaijieyong")); 
		QicaijieyongView qicaijieyongView =  qicaijieyongService.selectView(ew);
		return R.ok("查询器材借用成功").put("data", qicaijieyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QicaijieyongEntity qicaijieyong = qicaijieyongService.selectById(id);
        return R.ok().put("data", qicaijieyong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QicaijieyongEntity qicaijieyong = qicaijieyongService.selectById(id);
        return R.ok().put("data", qicaijieyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QicaijieyongEntity qicaijieyong, HttpServletRequest request){
    	qicaijieyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicaijieyong);
        qicaijieyongService.insert(qicaijieyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QicaijieyongEntity qicaijieyong, HttpServletRequest request){
    	qicaijieyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicaijieyong);
        qicaijieyongService.insert(qicaijieyong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QicaijieyongEntity qicaijieyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qicaijieyong);
        qicaijieyongService.updateById(qicaijieyong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QicaijieyongEntity> list = new ArrayList<QicaijieyongEntity>();
        for(Long id : ids) {
            QicaijieyongEntity qicaijieyong = qicaijieyongService.selectById(id);
            qicaijieyong.setSfsh(sfsh);
            qicaijieyong.setShhf(shhf);
            list.add(qicaijieyong);
        }
        qicaijieyongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qicaijieyongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
