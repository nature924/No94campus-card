package com.entity.vo;

import com.entity.MeishixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 美食信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public class MeishixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 菜品名称
	 */
	
	private String caipinmingcheng;
		
	/**
	 * 菜品类型
	 */
	
	private String caipinleixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 口味
	 */
	
	private String kouwei;
		
	/**
	 * 价格
	 */
	
	private Float jiage;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 菜品介绍
	 */
	
	private String caipinjieshao;
				
	
	/**
	 * 设置：菜品名称
	 */
	 
	public void setCaipinmingcheng(String caipinmingcheng) {
		this.caipinmingcheng = caipinmingcheng;
	}
	
	/**
	 * 获取：菜品名称
	 */
	public String getCaipinmingcheng() {
		return caipinmingcheng;
	}
				
	
	/**
	 * 设置：菜品类型
	 */
	 
	public void setCaipinleixing(String caipinleixing) {
		this.caipinleixing = caipinleixing;
	}
	
	/**
	 * 获取：菜品类型
	 */
	public String getCaipinleixing() {
		return caipinleixing;
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
	 * 设置：口味
	 */
	 
	public void setKouwei(String kouwei) {
		this.kouwei = kouwei;
	}
	
	/**
	 * 获取：口味
	 */
	public String getKouwei() {
		return kouwei;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Float jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getJiage() {
		return jiage;
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
	 * 设置：菜品介绍
	 */
	 
	public void setCaipinjieshao(String caipinjieshao) {
		this.caipinjieshao = caipinjieshao;
	}
	
	/**
	 * 获取：菜品介绍
	 */
	public String getCaipinjieshao() {
		return caipinjieshao;
	}
			
}
