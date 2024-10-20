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


import com.dao.KoufeixinxiDao;
import com.entity.KoufeixinxiEntity;
import com.service.KoufeixinxiService;
import com.entity.vo.KoufeixinxiVO;
import com.entity.view.KoufeixinxiView;

@Service("koufeixinxiService")
public class KoufeixinxiServiceImpl extends ServiceImpl<KoufeixinxiDao, KoufeixinxiEntity> implements KoufeixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KoufeixinxiEntity> page = this.selectPage(
                new Query<KoufeixinxiEntity>(params).getPage(),
                new EntityWrapper<KoufeixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KoufeixinxiEntity> wrapper) {
		  Page<KoufeixinxiView> page =new Query<KoufeixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KoufeixinxiVO> selectListVO(Wrapper<KoufeixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KoufeixinxiVO selectVO(Wrapper<KoufeixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KoufeixinxiView> selectListView(Wrapper<KoufeixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KoufeixinxiView selectView(Wrapper<KoufeixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
