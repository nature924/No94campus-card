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


import com.dao.HuiyiqiandaoDao;
import com.entity.HuiyiqiandaoEntity;
import com.service.HuiyiqiandaoService;
import com.entity.vo.HuiyiqiandaoVO;
import com.entity.view.HuiyiqiandaoView;

@Service("huiyiqiandaoService")
public class HuiyiqiandaoServiceImpl extends ServiceImpl<HuiyiqiandaoDao, HuiyiqiandaoEntity> implements HuiyiqiandaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuiyiqiandaoEntity> page = this.selectPage(
                new Query<HuiyiqiandaoEntity>(params).getPage(),
                new EntityWrapper<HuiyiqiandaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuiyiqiandaoEntity> wrapper) {
		  Page<HuiyiqiandaoView> page =new Query<HuiyiqiandaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuiyiqiandaoVO> selectListVO(Wrapper<HuiyiqiandaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuiyiqiandaoVO selectVO(Wrapper<HuiyiqiandaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuiyiqiandaoView> selectListView(Wrapper<HuiyiqiandaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuiyiqiandaoView selectView(Wrapper<HuiyiqiandaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
