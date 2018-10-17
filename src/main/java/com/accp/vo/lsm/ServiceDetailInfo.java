package com.accp.vo.lsm;

import java.util.Date;
import java.util.List;

import com.accp.pojo.Servicedes;

public class ServiceDetailInfo {
	private Integer serviceID;	//服务编号
	private String serviceTitle;	//服务标题
	private String serviceFuTitle;	//服务副标题
	private Integer servicePrice;	//服务价格
	private Integer serviceHour;	//小时/天
	private String serviceCostInclude;	//服务费用包含
	private Date serviceStartDate;	//服务开始时间
	private Date serviceEndDate;	//服务结束时间
	private String serviceIntro;	//服务简介
	private String serviceCity;	//服务城市	
	private float height;	//身高
	private Integer age;	//年龄
	private String constellation;	//星座
	private String profession;	//工作
	private String serviceCostTypeID;	//费用说明
	private String schoolRegion;	//学校地区
	private String schoolNameByCN;	//学校中文
	private String schoolNameByROK;	//学校韩文
	private String majoyNameByCN;	//专业中文
	private String majoyNameByROK;	//专业韩文
	private String serviceCoverImg;	//封面图
	private String serviceImgUrlOne;	//细节图一
	private String serviceImgUrlTwo;	//细节图二
	private String serviceImgUrlThree;	//细节图三
	private String serviceImgUrlFour;	//细节图四
	private List<Servicedes> serDesList;	//服务描述集合
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceFuTitle() {
		return serviceFuTitle;
	}
	public void setServiceFuTitle(String serviceFuTitle) {
		this.serviceFuTitle = serviceFuTitle;
	}
	public Integer getServiceHour() {
		return serviceHour;
	}
	public void setServiceHour(Integer serviceHour) {
		this.serviceHour = serviceHour;
	}
	public String getServiceCostInclude() {
		return serviceCostInclude;
	}
	public void setServiceCostInclude(String serviceCostInclude) {
		this.serviceCostInclude = serviceCostInclude;
	}
	public Date getServiceStartDate() {
		return serviceStartDate;
	}
	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}
	public Date getServiceEndDate() {
		return serviceEndDate;
	}
	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}
	public String getServiceIntro() {
		return serviceIntro;
	}
	public void setServiceIntro(String serviceIntro) {
		this.serviceIntro = serviceIntro;
	}
	public String getServiceCity() {
		return serviceCity;
	}
	public void setServiceCity(String serviceCity) {
		this.serviceCity = serviceCity;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getServiceCostTypeID() {
		return serviceCostTypeID;
	}
	public void setServiceCostTypeID(String serviceCostTypeID) {
		this.serviceCostTypeID = serviceCostTypeID;
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public String getServiceImgUrlOne() {
		return serviceImgUrlOne;
	}
	public void setServiceImgUrlOne(String serviceImgUrlOne) {
		this.serviceImgUrlOne = serviceImgUrlOne;
	}
	public String getServiceImgUrlTwo() {
		return serviceImgUrlTwo;
	}
	public void setServiceImgUrlTwo(String serviceImgUrlTwo) {
		this.serviceImgUrlTwo = serviceImgUrlTwo;
	}
	public String getServiceImgUrlThree() {
		return serviceImgUrlThree;
	}
	public void setServiceImgUrlThree(String serviceImgUrlThree) {
		this.serviceImgUrlThree = serviceImgUrlThree;
	}
	public String getServiceImgUrlFour() {
		return serviceImgUrlFour;
	}
	public void setServiceImgUrlFour(String serviceImgUrlFour) {
		this.serviceImgUrlFour = serviceImgUrlFour;
	}
	
	public Integer getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}
	
	public String getSchoolRegion() {
		return schoolRegion;
	}
	public void setSchoolRegion(String schoolRegion) {
		this.schoolRegion = schoolRegion;
	}
	public String getSchoolNameByCN() {
		return schoolNameByCN;
	}
	public void setSchoolNameByCN(String schoolNameByCN) {
		this.schoolNameByCN = schoolNameByCN;
	}
	public String getSchoolNameByROK() {
		return schoolNameByROK;
	}
	public void setSchoolNameByROK(String schoolNameByROK) {
		this.schoolNameByROK = schoolNameByROK;
	}
	public String getMajoyNameByCN() {
		return majoyNameByCN;
	}
	public void setMajoyNameByCN(String majoyNameByCN) {
		this.majoyNameByCN = majoyNameByCN;
	}
	public String getMajoyNameByROK() {
		return majoyNameByROK;
	}
	public void setMajoyNameByROK(String majoyNameByROK) {
		this.majoyNameByROK = majoyNameByROK;
	}
	public List<Servicedes> getSerDesList() {
		return serDesList;
	}
	public void setSerDesList(List<Servicedes> serDesList) {
		this.serDesList = serDesList;
	}
}
