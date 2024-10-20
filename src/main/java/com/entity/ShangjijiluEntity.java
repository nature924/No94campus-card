package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 上机记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
@TableName("shangjijilu")
public class ShangjijiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShangjijiluEntity() {
		
	}
	
	public ShangjijiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
					
	private String mingcheng;
	
	/**
	 * 上机日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：名称
	 */
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	/**
	 * 获取：名称
	 */
	public String getMingcheng() {
		return mingcheng;
	}
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
