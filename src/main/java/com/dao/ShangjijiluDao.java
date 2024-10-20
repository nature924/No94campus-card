package com.dao;

import com.entity.ShangjijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangjijiluVO;
import com.entity.view.ShangjijiluView;


/**
 * 上机记录
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
public interface ShangjijiluDao extends BaseMapper<ShangjijiluEntity> {
	
	List<ShangjijiluVO> selectListVO(@Param("ew") Wrapper<ShangjijiluEntity> wrapper);
	
	ShangjijiluVO selectVO(@Param("ew") Wrapper<ShangjijiluEntity> wrapper);
	
	List<ShangjijiluView> selectListView(@Param("ew") Wrapper<ShangjijiluEntity> wrapper);

	List<ShangjijiluView> selectListView(Pagination page,@Param("ew") Wrapper<ShangjijiluEntity> wrapper);
	
	ShangjijiluView selectView(@Param("ew") Wrapper<ShangjijiluEntity> wrapper);
	

}
