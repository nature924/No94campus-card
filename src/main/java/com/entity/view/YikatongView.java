package com.entity.view;

import com.entity.YikatongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 一卡通
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("yikatong")
public class YikatongView  extends YikatongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YikatongView(){
	}
 
 	public YikatongView(YikatongEntity yikatongEntity){
 	try {
			BeanUtils.copyProperties(this, yikatongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
