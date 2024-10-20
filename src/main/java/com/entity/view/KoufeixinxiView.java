package com.entity.view;

import com.entity.KoufeixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 扣费信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("koufeixinxi")
public class KoufeixinxiView  extends KoufeixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KoufeixinxiView(){
	}
 
 	public KoufeixinxiView(KoufeixinxiEntity koufeixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, koufeixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
