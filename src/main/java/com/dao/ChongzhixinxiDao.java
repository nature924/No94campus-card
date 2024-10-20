package com.dao;

import com.entity.ChongzhixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongzhixinxiVO;
import com.entity.view.ChongzhixinxiView;


/**
 * 充值信息
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface ChongzhixinxiDao extends BaseMapper<ChongzhixinxiEntity> {
	
	List<ChongzhixinxiVO> selectListVO(@Param("ew") Wrapper<ChongzhixinxiEntity> wrapper);
	
	ChongzhixinxiVO selectVO(@Param("ew") Wrapper<ChongzhixinxiEntity> wrapper);
	
	List<ChongzhixinxiView> selectListView(@Param("ew") Wrapper<ChongzhixinxiEntity> wrapper);

	List<ChongzhixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChongzhixinxiEntity> wrapper);
	
	ChongzhixinxiView selectView(@Param("ew") Wrapper<ChongzhixinxiEntity> wrapper);
	

}
