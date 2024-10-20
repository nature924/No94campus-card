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


import com.dao.ShangjijiluDao;
import com.entity.ShangjijiluEntity;
import com.service.ShangjijiluService;
import com.entity.vo.ShangjijiluVO;
import com.entity.view.ShangjijiluView;

@Service("shangjijiluService")
public class ShangjijiluServiceImpl extends ServiceImpl<ShangjijiluDao, ShangjijiluEntity> implements ShangjijiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangjijiluEntity> page = this.selectPage(
                new Query<ShangjijiluEntity>(params).getPage(),
                new EntityWrapper<ShangjijiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangjijiluEntity> wrapper) {
		  Page<ShangjijiluView> page =new Query<ShangjijiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangjijiluVO> selectListVO(Wrapper<ShangjijiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangjijiluVO selectVO(Wrapper<ShangjijiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangjijiluView> selectListView(Wrapper<ShangjijiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangjijiluView selectView(Wrapper<ShangjijiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
