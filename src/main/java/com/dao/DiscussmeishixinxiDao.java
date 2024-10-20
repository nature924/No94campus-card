package com.dao;

import com.entity.DiscussmeishixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmeishixinxiVO;
import com.entity.view.DiscussmeishixinxiView;


/**
 * 美食信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
public interface DiscussmeishixinxiDao extends BaseMapper<DiscussmeishixinxiEntity> {
	
	List<DiscussmeishixinxiVO> selectListVO(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
	
	DiscussmeishixinxiVO selectVO(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
	
	List<DiscussmeishixinxiView> selectListView(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);

	List<DiscussmeishixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
	
	DiscussmeishixinxiView selectView(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
	

}
