package com.dao;

import com.entity.HuiyiqiandaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuiyiqiandaoVO;
import com.entity.view.HuiyiqiandaoView;


/**
 * 会议签到
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface HuiyiqiandaoDao extends BaseMapper<HuiyiqiandaoEntity> {
	
	List<HuiyiqiandaoVO> selectListVO(@Param("ew") Wrapper<HuiyiqiandaoEntity> wrapper);
	
	HuiyiqiandaoVO selectVO(@Param("ew") Wrapper<HuiyiqiandaoEntity> wrapper);
	
	List<HuiyiqiandaoView> selectListView(@Param("ew") Wrapper<HuiyiqiandaoEntity> wrapper);

	List<HuiyiqiandaoView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyiqiandaoEntity> wrapper);
	
	HuiyiqiandaoView selectView(@Param("ew") Wrapper<HuiyiqiandaoEntity> wrapper);
	

}
