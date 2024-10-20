package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeishixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeishixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishixinxiView;


/**
 * 美食信息
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface MeishixinxiService extends IService<MeishixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishixinxiVO> selectListVO(Wrapper<MeishixinxiEntity> wrapper);
   	
   	MeishixinxiVO selectVO(@Param("ew") Wrapper<MeishixinxiEntity> wrapper);
   	
   	List<MeishixinxiView> selectListView(Wrapper<MeishixinxiEntity> wrapper);
   	
   	MeishixinxiView selectView(@Param("ew") Wrapper<MeishixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishixinxiEntity> wrapper);
   	

}

