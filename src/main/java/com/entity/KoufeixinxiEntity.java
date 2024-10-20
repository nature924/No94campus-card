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
 * 扣费信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("koufeixinxi")
public class KoufeixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KoufeixinxiEntity() {
		
	}
	
	public KoufeixinxiEntity(T t) {
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
	 * 一卡通号
	 */
					
	private String yikatonghao;
	
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
	 * 设置：一卡通号
	 */
	public void setYikatonghao(String yikatonghao) {
		this.yikatonghao = yikatonghao;
	}
	/**
	 * 获取：一卡通号
	 */
	public String getYikatonghao() {
		return yikatonghao;
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
