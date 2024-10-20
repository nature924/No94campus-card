package com.entity.view;

import com.entity.TongzhixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 通知信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("tongzhixinxi")
public class TongzhixinxiView  extends TongzhixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TongzhixinxiView(){
	}
 
 	public TongzhixinxiView(TongzhixinxiEntity tongzhixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tongzhixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
