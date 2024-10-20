package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TongzhixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TongzhixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TongzhixinxiView;


/**
 * 通知信息
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface TongzhixinxiService extends IService<TongzhixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TongzhixinxiVO> selectListVO(Wrapper<TongzhixinxiEntity> wrapper);
   	
   	TongzhixinxiVO selectVO(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);
   	
   	List<TongzhixinxiView> selectListView(Wrapper<TongzhixinxiEntity> wrapper);
   	
   	TongzhixinxiView selectView(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TongzhixinxiEntity> wrapper);
   	

}

