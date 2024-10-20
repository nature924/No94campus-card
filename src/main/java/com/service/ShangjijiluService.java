package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangjijiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangjijiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangjijiluView;


/**
 * 上机记录
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
public interface ShangjijiluService extends IService<ShangjijiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangjijiluVO> selectListVO(Wrapper<ShangjijiluEntity> wrapper);
   	
   	ShangjijiluVO selectVO(@Param("ew") Wrapper<ShangjijiluEntity> wrapper);
   	
   	List<ShangjijiluView> selectListView(Wrapper<ShangjijiluEntity> wrapper);
   	
   	ShangjijiluView selectView(@Param("ew") Wrapper<ShangjijiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangjijiluEntity> wrapper);
   	

}

