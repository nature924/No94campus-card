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


import com.dao.ChongzhixinxiDao;
import com.entity.ChongzhixinxiEntity;
import com.service.ChongzhixinxiService;
import com.entity.vo.ChongzhixinxiVO;
import com.entity.view.ChongzhixinxiView;

@Service("chongzhixinxiService")
public class ChongzhixinxiServiceImpl extends ServiceImpl<ChongzhixinxiDao, ChongzhixinxiEntity> implements ChongzhixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongzhixinxiEntity> page = this.selectPage(
                new Query<ChongzhixinxiEntity>(params).getPage(),
                new EntityWrapper<ChongzhixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongzhixinxiEntity> wrapper) {
		  Page<ChongzhixinxiView> page =new Query<ChongzhixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongzhixinxiVO> selectListVO(Wrapper<ChongzhixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongzhixinxiVO selectVO(Wrapper<ChongzhixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongzhixinxiView> selectListView(Wrapper<ChongzhixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongzhixinxiView selectView(Wrapper<ChongzhixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
