package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmeishixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmeishixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmeishixinxiView;


/**
 * 美食信息评论表
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
public interface DiscussmeishixinxiService extends IService<DiscussmeishixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmeishixinxiVO> selectListVO(Wrapper<DiscussmeishixinxiEntity> wrapper);
   	
   	DiscussmeishixinxiVO selectVO(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
   	
   	List<DiscussmeishixinxiView> selectListView(Wrapper<DiscussmeishixinxiEntity> wrapper);
   	
   	DiscussmeishixinxiView selectView(@Param("ew") Wrapper<DiscussmeishixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmeishixinxiEntity> wrapper);
   	

}

