package com.entity.view;

import com.entity.ShangjijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 上机记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
@TableName("shangjijilu")
public class ShangjijiluView  extends ShangjijiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangjijiluView(){
	}
 
 	public ShangjijiluView(ShangjijiluEntity shangjijiluEntity){
 	try {
			BeanUtils.copyProperties(this, shangjijiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
