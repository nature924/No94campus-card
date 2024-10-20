package com.dao;

import com.entity.GuashishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuashishenqingVO;
import com.entity.view.GuashishenqingView;


/**
 * 挂失申请
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface GuashishenqingDao extends BaseMapper<GuashishenqingEntity> {
	
	List<GuashishenqingVO> selectListVO(@Param("ew") Wrapper<GuashishenqingEntity> wrapper);
	
	GuashishenqingVO selectVO(@Param("ew") Wrapper<GuashishenqingEntity> wrapper);
	
	List<GuashishenqingView> selectListView(@Param("ew") Wrapper<GuashishenqingEntity> wrapper);

	List<GuashishenqingView> selectListView(Pagination page,@Param("ew") Wrapper<GuashishenqingEntity> wrapper);
	
	GuashishenqingView selectView(@Param("ew") Wrapper<GuashishenqingEntity> wrapper);
	

}
