package com.entity.vo;

import com.entity.TiyuqicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 体育器材
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public class TiyuqicaiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 器材类型
	 */
	
	private String qicaileixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 器材介绍
	 */
	
	private String qicaijieshao;
				
	
	/**
	 * 设置：器材类型
	 */
	 
	public void setQicaileixing(String qicaileixing) {
		this.qicaileixing = qicaileixing;
	}
	
	/**
	 * 获取：器材类型
	 */
	public String getQicaileixing() {
		return qicaileixing;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：器材介绍
	 */
	 
	public void setQicaijieshao(String qicaijieshao) {
		this.qicaijieshao = qicaijieshao;
	}
	
	/**
	 * 获取：器材介绍
	 */
	public String getQicaijieshao() {
		return qicaijieshao;
	}
			
}
