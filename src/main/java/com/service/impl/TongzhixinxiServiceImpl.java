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


import com.dao.TongzhixinxiDao;
import com.entity.TongzhixinxiEntity;
import com.service.TongzhixinxiService;
import com.entity.vo.TongzhixinxiVO;
import com.entity.view.TongzhixinxiView;

@Service("tongzhixinxiService")
public class TongzhixinxiServiceImpl extends ServiceImpl<TongzhixinxiDao, TongzhixinxiEntity> implements TongzhixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TongzhixinxiEntity> page = this.selectPage(
                new Query<TongzhixinxiEntity>(params).getPage(),
                new EntityWrapper<TongzhixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TongzhixinxiEntity> wrapper) {
		  Page<TongzhixinxiView> page =new Query<TongzhixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TongzhixinxiVO> selectListVO(Wrapper<TongzhixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TongzhixinxiVO selectVO(Wrapper<TongzhixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TongzhixinxiView> selectListView(Wrapper<TongzhixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TongzhixinxiView selectView(Wrapper<TongzhixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
