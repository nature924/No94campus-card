package com.dao;

import com.entity.TongzhixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TongzhixinxiVO;
import com.entity.view.TongzhixinxiView;


/**
 * 通知信息
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface TongzhixinxiDao extends BaseMapper<TongzhixinxiEntity> {
	
	List<TongzhixinxiVO> selectListVO(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);
	
	TongzhixinxiVO selectVO(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);
	
	List<TongzhixinxiView> selectListView(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);

	List<TongzhixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);
	
	TongzhixinxiView selectView(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);
	

}
