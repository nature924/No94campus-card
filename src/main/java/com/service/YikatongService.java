package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YikatongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YikatongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YikatongView;


/**
 * 一卡通
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface YikatongService extends IService<YikatongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YikatongVO> selectListVO(Wrapper<YikatongEntity> wrapper);
   	
   	YikatongVO selectVO(@Param("ew") Wrapper<YikatongEntity> wrapper);
   	
   	List<YikatongView> selectListView(Wrapper<YikatongEntity> wrapper);
   	
   	YikatongView selectView(@Param("ew") Wrapper<YikatongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YikatongEntity> wrapper);
   	

}

