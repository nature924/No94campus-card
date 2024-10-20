package com.dao;

import com.entity.QicaiguihaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QicaiguihaiVO;
import com.entity.view.QicaiguihaiView;


/**
 * 器材归还
 * 
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface QicaiguihaiDao extends BaseMapper<QicaiguihaiEntity> {
	
	List<QicaiguihaiVO> selectListVO(@Param("ew") Wrapper<QicaiguihaiEntity> wrapper);
	
	QicaiguihaiVO selectVO(@Param("ew") Wrapper<QicaiguihaiEntity> wrapper);
	
	List<QicaiguihaiView> selectListView(@Param("ew") Wrapper<QicaiguihaiEntity> wrapper);

	List<QicaiguihaiView> selectListView(Pagination page,@Param("ew") Wrapper<QicaiguihaiEntity> wrapper);
	
	QicaiguihaiView selectView(@Param("ew") Wrapper<QicaiguihaiEntity> wrapper);
	

}
