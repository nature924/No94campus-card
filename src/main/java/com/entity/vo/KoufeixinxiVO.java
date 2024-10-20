package com.entity.vo;

import com.entity.KoufeixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 扣费信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
public class KoufeixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 金额
	 */
	
	private Integer jine;
		
	/**
	 * 扣费说明
	 */
	
	private String koufeishuoming;
		
	/**
	 * 扣费时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date koufeishijian;
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：金额
	 */
	 
	public void setJine(Integer jine) {
		this.jine = jine;
	}
	
	/**
	 * 获取：金额
	 */
	public Integer getJine() {
		return jine;
	}
				
	
	/**
	 * 设置：扣费说明
	 */
	 
	public void setKoufeishuoming(String koufeishuoming) {
		this.koufeishuoming = koufeishuoming;
	}
	
	/**
	 * 获取：扣费说明
	 */
	public String getKoufeishuoming() {
		return koufeishuoming;
	}
				
	
	/**
	 * 设置：扣费时间
	 */
	 
	public void setKoufeishijian(Date koufeishijian) {
		this.koufeishijian = koufeishijian;
	}
	
	/**
	 * 获取：扣费时间
	 */
	public Date getKoufeishijian() {
		return koufeishijian;
	}
			
}
