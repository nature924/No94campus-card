package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GuashishenqingDao;
import com.entity.GuashishenqingEntity;
import com.service.GuashishenqingService;
import com.entity.vo.GuashishenqingVO;
import com.entity.view.GuashishenqingView;

@Service("guashishenqingService")
public class GuashishenqingServiceImpl extends ServiceImpl<GuashishenqingDao, GuashishenqingEntity> implements GuashishenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuashishenqingEntity> page = this.selectPage(
                new Query<GuashishenqingEntity>(params).getPage(),
                new EntityWrapper<GuashishenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuashishenqingEntity> wrapper) {
		  Page<GuashishenqingView> page =new Query<GuashishenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GuashishenqingVO> selectListVO(Wrapper<GuashishenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuashishenqingVO selectVO(Wrapper<GuashishenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuashishenqingView> selectListView(Wrapper<GuashishenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuashishenqingView selectView(Wrapper<GuashishenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
