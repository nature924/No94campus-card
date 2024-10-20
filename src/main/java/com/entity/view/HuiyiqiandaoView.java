package com.entity.view;

import com.entity.HuiyiqiandaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 会议签到
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("huiyiqiandao")
public class HuiyiqiandaoView  extends HuiyiqiandaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuiyiqiandaoView(){
	}
 
 	public HuiyiqiandaoView(HuiyiqiandaoEntity huiyiqiandaoEntity){
 	try {
			BeanUtils.copyProperties(this, huiyiqiandaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
