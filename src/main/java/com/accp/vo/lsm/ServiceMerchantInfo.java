package com.accp.vo.lsm;

public class ServiceMerchantInfo {
	private Integer userID;	//用户编号
	private String shopImg;	//店铺图片路径
	private String shopName;	//店铺名
	private float merchantLevel;	//用户星级
	private String firstServiceLevelName;	//第一服务名称
	private String SecondServiceLevelName;	//第二服务名称
	private Integer orderCount;	//订单数
	private Integer collectCount;	//收藏数
	private String liveCityName;	//所在城市名
	private String languageNameText;	//服务语言
	private Integer guaranteeMoney;	//保证金
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	public float getMerchantLevel() {
		return merchantLevel;
	}
	public void setMerchantLevel(float merchantLevel) {
		this.merchantLevel = merchantLevel;
	}
	public String getFirstServiceLevelName() {
		return firstServiceLevelName;
	}
	public void setFirstServiceLevelName(String firstServiceLevelName) {
		this.firstServiceLevelName = firstServiceLevelName;
	}
	public String getSecondServiceLevelName() {
		return SecondServiceLevelName;
	}
	public void setSecondServiceLevelName(String secondServiceLevelName) {
		SecondServiceLevelName = secondServiceLevelName;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Integer getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}
	public String getLiveCityName() {
		return liveCityName;
	}
	public void setLiveCityName(String liveCityName) {
		this.liveCityName = liveCityName;
	}
	public String getLanguageNameText() {
		return languageNameText;
	}
	public void setLanguageNameText(String languageNameText) {
		this.languageNameText = languageNameText;
	}
	public Integer getGuaranteeMoney() {
		return guaranteeMoney;
	}
	public void setGuaranteeMoney(Integer guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
	}
	
}
