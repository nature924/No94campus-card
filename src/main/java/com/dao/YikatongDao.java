package com.dao;

import com.entity.YikatongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YikatongVO;
import com.entity.view.YikatongView;


/**
 * 一卡通
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface YikatongDao extends BaseMapper<YikatongEntity> {
	
	List<YikatongVO> selectListVO(@Param("ew") Wrapper<YikatongEntity> wrapper);
	
	YikatongVO selectVO(@Param("ew") Wrapper<YikatongEntity> wrapper);
	
	List<YikatongView> selectListView(@Param("ew") Wrapper<YikatongEntity> wrapper);

	List<YikatongView> selectListView(Pagination page,@Param("ew") Wrapper<YikatongEntity> wrapper);
	
	YikatongView selectView(@Param("ew") Wrapper<YikatongEntity> wrapper);
	

}
