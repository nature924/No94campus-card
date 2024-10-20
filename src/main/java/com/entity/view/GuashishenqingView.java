package com.entity.view;

import com.entity.GuashishenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 挂失申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("guashishenqing")
public class GuashishenqingView  extends GuashishenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GuashishenqingView(){
	}
 
 	public GuashishenqingView(GuashishenqingEntity guashishenqingEntity){
 	try {
			BeanUtils.copyProperties(this, guashishenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
