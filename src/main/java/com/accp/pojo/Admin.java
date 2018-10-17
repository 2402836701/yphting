package com.accp.pojo;

import java.util.Date;

public class Admin {
    private Integer adminid;

    private Integer admintype;

    private String name;

    private String password;

    private Boolean socialmanagement;

    private Boolean ordermanagement;

    private Boolean servicemanagement;

    private Boolean membermanagement;

    private Boolean advertisingmanagement;

    private Boolean systemmanagement;

    private Date creationtime;

    private String founder;

    private String ip;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getAdmintype() {
        return admintype;
    }

    public void setAdmintype(Integer admintype) {
        this.admintype = admintype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getSocialmanagement() {
        return socialmanagement;
    }

    public void setSocialmanagement(Boolean socialmanagement) {
        this.socialmanagement = socialmanagement;
    }

    public Boolean getOrdermanagement() {
        return ordermanagement;
    }

    public void setOrdermanagement(Boolean ordermanagement) {
        this.ordermanagement = ordermanagement;
    }

    public Boolean getServicemanagement() {
        return servicemanagement;
    }

    public void setServicemanagement(Boolean servicemanagement) {
        this.servicemanagement = servicemanagement;
    }

    public Boolean getMembermanagement() {
        return membermanagement;
    }

    public void setMembermanagement(Boolean membermanagement) {
        this.membermanagement = membermanagement;
    }

    public Boolean getAdvertisingmanagement() {
        return advertisingmanagement;
    }

    public void setAdvertisingmanagement(Boolean advertisingmanagement) {
        this.advertisingmanagement = advertisingmanagement;
    }

    public Boolean getSystemmanagement() {
        return systemmanagement;
    }

    public void setSystemmanagement(Boolean systemmanagement) {
        this.systemmanagement = systemmanagement;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}