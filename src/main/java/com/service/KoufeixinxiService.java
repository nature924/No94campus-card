package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KoufeixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KoufeixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KoufeixinxiView;


/**
 * 扣费信息
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface KoufeixinxiService extends IService<KoufeixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KoufeixinxiVO> selectListVO(Wrapper<KoufeixinxiEntity> wrapper);
   	
   	KoufeixinxiVO selectVO(@Param("ew") Wrapper<KoufeixinxiEntity> wrapper);
   	
   	List<KoufeixinxiView> selectListView(Wrapper<KoufeixinxiEntity> wrapper);
   	
   	KoufeixinxiView selectView(@Param("ew") Wrapper<KoufeixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KoufeixinxiEntity> wrapper);
   	

}

