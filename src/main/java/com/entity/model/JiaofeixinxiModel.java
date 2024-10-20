package com.entity.model;

import com.entity.JiaofeixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 缴费信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
public class JiaofeixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 缴费项目
	 */
	
	private String jiaofeixiangmu;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 缴费金额
	 */
	
	private Float jiaofeijine;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 缴费说明
	 */
	
	private String jiaofeishuoming;
				
	
	/**
	 * 设置：缴费项目
	 */
	 
	public void setJiaofeixiangmu(String jiaofeixiangmu) {
		this.jiaofeixiangmu = jiaofeixiangmu;
	}
	
	/**
	 * 获取：缴费项目
	 */
	public String getJiaofeixiangmu() {
		return jiaofeixiangmu;
	}
				
	
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
	 * 设置：缴费金额
	 */
	 
	public void setJiaofeijine(Float jiaofeijine) {
		this.jiaofeijine = jiaofeijine;
	}
	
	/**
	 * 获取：缴费金额
	 */
	public Float getJiaofeijine() {
		return jiaofeijine;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：缴费说明
	 */
	 
	public void setJiaofeishuoming(String jiaofeishuoming) {
		this.jiaofeishuoming = jiaofeishuoming;
	}
	
	/**
	 * 获取：缴费说明
	 */
	public String getJiaofeishuoming() {
		return jiaofeishuoming;
	}
			
}
