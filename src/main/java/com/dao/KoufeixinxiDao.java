package com.dao;

import com.entity.KoufeixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KoufeixinxiVO;
import com.entity.view.KoufeixinxiView;


/**
 * 扣费信息
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface KoufeixinxiDao extends BaseMapper<KoufeixinxiEntity> {
	
	List<KoufeixinxiVO> selectListVO(@Param("ew") Wrapper<KoufeixinxiEntity> wrapper);
	
	KoufeixinxiVO selectVO(@Param("ew") Wrapper<KoufeixinxiEntity> wrapper);
	
	List<KoufeixinxiView> selectListView(@Param("ew") Wrapper<KoufeixinxiEntity> wrapper);

	List<KoufeixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KoufeixinxiEntity> wrapper);
	
	KoufeixinxiView selectView(@Param("ew") Wrapper<KoufeixinxiEntity> wrapper);
	

}
