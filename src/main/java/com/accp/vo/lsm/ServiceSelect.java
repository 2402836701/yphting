package com.accp.vo.lsm;


public class ServiceSelect {
	private String txt;	//模糊查询框
	private String startDate;	//开始日期
	private String endDate;	//结束日期
	private Integer country;	//国家编号
	private String city;	//城市
	private Integer firstStid;	//一级服务编号
	private Integer stid;	//类别编号
	private Integer stidChild;	//子类别编号
	private Integer transactionValueMin;	//级别交易额最小值
	private Integer transactionValueMax;	//级别交易额最大值
	private Integer transactionValueID;	//级别交易额编号	存类别编号判断取值
	private Integer authentication;	//是否鉴定
	private Integer orderByPop;	//人气排序
	private Integer orderByPrice;	//价格排序
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getFirstStid() {
		return firstStid;
	}
	public void setFirstStid(Integer firstStid) {
		this.firstStid = firstStid;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public Integer getStidChild() {
		return stidChild;
	}
	public void setStidChild(Integer stidChild) {
		this.stidChild = stidChild;
	}
	public Integer getTransactionValueMin() {
		return transactionValueMin;
	}
	public void setTransactionValueMin(Integer transactionValueMin) {
		this.transactionValueMin = transactionValueMin;
	}
	public Integer getTransactionValueMax() {
		return transactionValueMax;
	}
	public void setTransactionValueMax(Integer transactionValueMax) {
		this.transactionValueMax = transactionValueMax;
	}
	public Integer getTransactionValueID() {
		return transactionValueID;
	}
	public void setTransactionValueID(Integer transactionValueID) {
		this.transactionValueID = transactionValueID;
	}
	public Integer isAuthentication() {
		return authentication;
	}
	public void setAuthentication(Integer authentication) {
		this.authentication = authentication;
	}
	public Integer getOrderByPop() {
		return orderByPop;
	}
	public void setOrderByPop(Integer orderByPop) {
		this.orderByPop = orderByPop;
	}
	public Integer getOrderByPrice() {
		return orderByPrice;
	}
	public void setOrderByPrice(Integer orderByPrice) {
		this.orderByPrice = orderByPrice;
	}
	
}
