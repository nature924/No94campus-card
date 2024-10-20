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


import com.dao.ShitangjiucanDao;
import com.entity.ShitangjiucanEntity;
import com.service.ShitangjiucanService;
import com.entity.vo.ShitangjiucanVO;
import com.entity.view.ShitangjiucanView;

@Service("shitangjiucanService")
public class ShitangjiucanServiceImpl extends ServiceImpl<ShitangjiucanDao, ShitangjiucanEntity> implements ShitangjiucanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShitangjiucanEntity> page = this.selectPage(
                new Query<ShitangjiucanEntity>(params).getPage(),
                new EntityWrapper<ShitangjiucanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShitangjiucanEntity> wrapper) {
		  Page<ShitangjiucanView> page =new Query<ShitangjiucanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShitangjiucanVO> selectListVO(Wrapper<ShitangjiucanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShitangjiucanVO selectVO(Wrapper<ShitangjiucanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShitangjiucanView> selectListView(Wrapper<ShitangjiucanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShitangjiucanView selectView(Wrapper<ShitangjiucanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShitangjiucanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShitangjiucanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShitangjiucanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
