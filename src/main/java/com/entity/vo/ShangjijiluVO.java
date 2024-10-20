package com.entity.vo;

import com.entity.ShangjijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 上机记录
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
public class ShangjijiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 上机日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shangjiriqi;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 上机时长
	 */
	
	private String shangjishizhang;
		
	/**
	 * 上机费用
	 */
	
	private Float shangjifeiyong;
		
	/**
	 * 上机说明
	 */
	
	private String shangjishuoming;
				
	
	/**
	 * 设置：上机日期
	 */
	 
	public void setShangjiriqi(Date shangjiriqi) {
		this.shangjiriqi = shangjiriqi;
	}
	
	/**
	 * 获取：上机日期
	 */
	public Date getShangjiriqi() {
		return shangjiriqi;
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
	 * 设置：上机时长
	 */
	 
	public void setShangjishizhang(String shangjishizhang) {
		this.shangjishizhang = shangjishizhang;
	}
	
	/**
	 * 获取：上机时长
	 */
	public String getShangjishizhang() {
		return shangjishizhang;
	}
				
	
	/**
	 * 设置：上机费用
	 */
	 
	public void setShangjifeiyong(Float shangjifeiyong) {
		this.shangjifeiyong = shangjifeiyong;
	}
	
	/**
	 * 获取：上机费用
	 */
	public Float getShangjifeiyong() {
		return shangjifeiyong;
	}
				
	
	/**
	 * 设置：上机说明
	 */
	 
	public void setShangjishuoming(String shangjishuoming) {
		this.shangjishuoming = shangjishuoming;
	}
	
	/**
	 * 获取：上机说明
	 */
	public String getShangjishuoming() {
		return shangjishuoming;
	}
			
}
