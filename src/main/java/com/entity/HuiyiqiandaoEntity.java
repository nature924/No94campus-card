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
 * 会议签到
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("huiyiqiandao")
public class HuiyiqiandaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuiyiqiandaoEntity() {
		
	}
	
	public HuiyiqiandaoEntity(T t) {
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
	 * 会议名称
	 */
					
	private String huiyimingcheng;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 签到说明
	 */
					
	private String qiandaoshuoming;
	
	/**
	 * 签到时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date qiandaoshijian;
	
	/**
	 * 经度
	 */
					
	private Float longitude;
	
	/**
	 * 纬度
	 */
					
	private Float latitude;
	
	/**
	 * 地址
	 */
					
	private String fulladdress;
	
	
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
	 * 设置：会议名称
	 */
	public void setHuiyimingcheng(String huiyimingcheng) {
		this.huiyimingcheng = huiyimingcheng;
	}
	/**
	 * 获取：会议名称
	 */
	public String getHuiyimingcheng() {
		return huiyimingcheng;
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
	 * 设置：签到说明
	 */
	public void setQiandaoshuoming(String qiandaoshuoming) {
		this.qiandaoshuoming = qiandaoshuoming;
	}
	/**
	 * 获取：签到说明
	 */
	public String getQiandaoshuoming() {
		return qiandaoshuoming;
	}
	/**
	 * 设置：签到时间
	 */
	public void setQiandaoshijian(Date qiandaoshijian) {
		this.qiandaoshijian = qiandaoshijian;
	}
	/**
	 * 获取：签到时间
	 */
	public Date getQiandaoshijian() {
		return qiandaoshijian;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public Float getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public Float getLatitude() {
		return latitude;
	}
	/**
	 * 设置：地址
	 */
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	/**
	 * 获取：地址
	 */
	public String getFulladdress() {
		return fulladdress;
	}

}
