package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuashishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuashishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuashishenqingView;


/**
 * 挂失申请
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface GuashishenqingService extends IService<GuashishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuashishenqingVO> selectListVO(Wrapper<GuashishenqingEntity> wrapper);
   	
   	GuashishenqingVO selectVO(@Param("ew") Wrapper<GuashishenqingEntity> wrapper);
   	
   	List<GuashishenqingView> selectListView(Wrapper<GuashishenqingEntity> wrapper);
   	
   	GuashishenqingView selectView(@Param("ew") Wrapper<GuashishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuashishenqingEntity> wrapper);
   	

}

