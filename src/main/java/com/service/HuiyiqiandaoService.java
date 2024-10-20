package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuiyiqiandaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuiyiqiandaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuiyiqiandaoView;


/**
 * 会议签到
 *
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public interface HuiyiqiandaoService extends IService<HuiyiqiandaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuiyiqiandaoVO> selectListVO(Wrapper<HuiyiqiandaoEntity> wrapper);
   	
   	HuiyiqiandaoVO selectVO(@Param("ew") Wrapper<HuiyiqiandaoEntity> wrapper);
   	
   	List<HuiyiqiandaoView> selectListView(Wrapper<HuiyiqiandaoEntity> wrapper);
   	
   	HuiyiqiandaoView selectView(@Param("ew") Wrapper<HuiyiqiandaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyiqiandaoEntity> wrapper);
   	

}

