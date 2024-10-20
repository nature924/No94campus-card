package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongzhixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongzhixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongzhixinxiView;


/**
 * 充值信息
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface ChongzhixinxiService extends IService<ChongzhixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongzhixinxiVO> selectListVO(Wrapper<ChongzhixinxiEntity> wrapper);
   	
   	ChongzhixinxiVO selectVO(@Param("ew") Wrapper<ChongzhixinxiEntity> wrapper);
   	
   	List<ChongzhixinxiView> selectListView(Wrapper<ChongzhixinxiEntity> wrapper);
   	
   	ChongzhixinxiView selectView(@Param("ew") Wrapper<ChongzhixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongzhixinxiEntity> wrapper);
   	

}

