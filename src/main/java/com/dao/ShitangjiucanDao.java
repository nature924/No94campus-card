package com.dao;

import com.entity.ShitangjiucanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShitangjiucanVO;
import com.entity.view.ShitangjiucanView;


/**
 * 食堂就餐
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface ShitangjiucanDao extends BaseMapper<ShitangjiucanEntity> {
	
	List<ShitangjiucanVO> selectListVO(@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);
	
	ShitangjiucanVO selectVO(@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);
	
	List<ShitangjiucanView> selectListView(@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);

	List<ShitangjiucanView> selectListView(Pagination page,@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);
	
	ShitangjiucanView selectView(@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);



}
