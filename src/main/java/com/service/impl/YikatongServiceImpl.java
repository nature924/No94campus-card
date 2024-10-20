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


import com.dao.YikatongDao;
import com.entity.YikatongEntity;
import com.service.YikatongService;
import com.entity.vo.YikatongVO;
import com.entity.view.YikatongView;

@Service("yikatongService")
public class YikatongServiceImpl extends ServiceImpl<YikatongDao, YikatongEntity> implements YikatongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YikatongEntity> page = this.selectPage(
                new Query<YikatongEntity>(params).getPage(),
                new EntityWrapper<YikatongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YikatongEntity> wrapper) {
		  Page<YikatongView> page =new Query<YikatongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YikatongVO> selectListVO(Wrapper<YikatongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YikatongVO selectVO(Wrapper<YikatongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YikatongView> selectListView(Wrapper<YikatongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YikatongView selectView(Wrapper<YikatongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
