package com.entity.vo;

import com.entity.TushuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 图书信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public class TushuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图书名称
	 */
	
	private String tushumingcheng;
		
	/**
	 * 图书类型
	 */
	
	private String tushuleixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 可借数量
	 */
	
	private Integer kejieshuliang;
		
	/**
	 * 作者
	 */
	
	private String zuozhe;
		
	/**
	 * 出版社
	 */
	
	private String chubanshe;
		
	/**
	 * 借阅须知
	 */
	
	private String jieyuexuzhi;
		
	/**
	 * 图书介绍
	 */
	
	private String tushujieshao;
				
	
	/**
	 * 设置：图书名称
	 */
	 
	public void setTushumingcheng(String tushumingcheng) {
		this.tushumingcheng = tushumingcheng;
	}
	
	/**
	 * 获取：图书名称
	 */
	public String getTushumingcheng() {
		return tushumingcheng;
	}
				
	
	/**
	 * 设置：图书类型
	 */
	 
	public void setTushuleixing(String tushuleixing) {
		this.tushuleixing = tushuleixing;
	}
	
	/**
	 * 获取：图书类型
	 */
	public String getTushuleixing() {
		return tushuleixing;
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
	 * 设置：可借数量
	 */
	 
	public void setKejieshuliang(Integer kejieshuliang) {
		this.kejieshuliang = kejieshuliang;
	}
	
	/**
	 * 获取：可借数量
	 */
	public Integer getKejieshuliang() {
		return kejieshuliang;
	}
				
	
	/**
	 * 设置：作者
	 */
	 
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	
	/**
	 * 获取：作者
	 */
	public String getZuozhe() {
		return zuozhe;
	}
				
	
	/**
	 * 设置：出版社
	 */
	 
	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	
	/**
	 * 获取：出版社
	 */
	public String getChubanshe() {
		return chubanshe;
	}
				
	
	/**
	 * 设置：借阅须知
	 */
	 
	public void setJieyuexuzhi(String jieyuexuzhi) {
		this.jieyuexuzhi = jieyuexuzhi;
	}
	
	/**
	 * 获取：借阅须知
	 */
	public String getJieyuexuzhi() {
		return jieyuexuzhi;
	}
				
	
	/**
	 * 设置：图书介绍
	 */
	 
	public void setTushujieshao(String tushujieshao) {
		this.tushujieshao = tushujieshao;
	}
	
	/**
	 * 获取：图书介绍
	 */
	public String getTushujieshao() {
		return tushujieshao;
	}
			
}
