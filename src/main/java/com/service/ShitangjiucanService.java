package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShitangjiucanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShitangjiucanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShitangjiucanView;


/**
 * 食堂就餐
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface ShitangjiucanService extends IService<ShitangjiucanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShitangjiucanVO> selectListVO(Wrapper<ShitangjiucanEntity> wrapper);
   	
   	ShitangjiucanVO selectVO(@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);
   	
   	List<ShitangjiucanView> selectListView(Wrapper<ShitangjiucanEntity> wrapper);
   	
   	ShitangjiucanView selectView(@Param("ew") Wrapper<ShitangjiucanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShitangjiucanEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShitangjiucanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShitangjiucanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShitangjiucanEntity> wrapper);



}

