package com.accp.vo.lsm;

public class ServicesVO {
	private Integer serviceID;	//服务编号
	private Integer userID;	//用户编号
	private String serviceTitle;	//服务标题
	private String serviceCoverImg;	//服务封面图路径
	private Integer servicePrice;	//服务价格
	private boolean recommendBool;	//商家推荐
	private String shopImg;	//店铺图片路径
	private String shopName;	//店铺名
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public Integer getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}
	public boolean isRecommendBool() {
		return recommendBool;
	}
	public void setRecommendBool(boolean recommendBool) {
		this.recommendBool = recommendBool;
	}
	
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
}
