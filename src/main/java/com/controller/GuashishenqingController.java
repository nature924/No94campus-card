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

import com.entity.GuashishenqingEntity;
import com.entity.view.GuashishenqingView;

import com.service.GuashishenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 挂失申请
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@RestController
@RequestMapping("/guashishenqing")
public class GuashishenqingController {
    @Autowired
    private GuashishenqingService guashishenqingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuashishenqingEntity guashishenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			guashishenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GuashishenqingEntity> ew = new EntityWrapper<GuashishenqingEntity>();

		PageUtils page = guashishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guashishenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuashishenqingEntity guashishenqing, 
		HttpServletRequest request){
        EntityWrapper<GuashishenqingEntity> ew = new EntityWrapper<GuashishenqingEntity>();

		PageUtils page = guashishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guashishenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuashishenqingEntity guashishenqing){
       	EntityWrapper<GuashishenqingEntity> ew = new EntityWrapper<GuashishenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guashishenqing, "guashishenqing")); 
        return R.ok().put("data", guashishenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuashishenqingEntity guashishenqing){
        EntityWrapper< GuashishenqingEntity> ew = new EntityWrapper< GuashishenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guashishenqing, "guashishenqing")); 
		GuashishenqingView guashishenqingView =  guashishenqingService.selectView(ew);
		return R.ok("查询挂失申请成功").put("data", guashishenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuashishenqingEntity guashishenqing = guashishenqingService.selectById(id);
        return R.ok().put("data", guashishenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuashishenqingEntity guashishenqing = guashishenqingService.selectById(id);
        return R.ok().put("data", guashishenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuashishenqingEntity guashishenqing, HttpServletRequest request){
    	guashishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guashishenqing);
        guashishenqingService.insert(guashishenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuashishenqingEntity guashishenqing, HttpServletRequest request){
    	guashishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guashishenqing);
        guashishenqingService.insert(guashishenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuashishenqingEntity guashishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guashishenqing);
        guashishenqingService.updateById(guashishenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<GuashishenqingEntity> list = new ArrayList<GuashishenqingEntity>();
        for(Long id : ids) {
            GuashishenqingEntity guashishenqing = guashishenqingService.selectById(id);
            guashishenqing.setSfsh(sfsh);
            guashishenqing.setShhf(shhf);
            list.add(guashishenqing);
        }
        guashishenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guashishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
