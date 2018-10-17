package com.accp.pojo;

public class Integral {
    private Integer integralid;

    private String integralname;

    private Integer integral;

    public Integer getIntegralid() {
        return integralid;
    }

    public void setIntegralid(Integer integralid) {
        this.integralid = integralid;
    }

    public String getIntegralname() {
        return integralname;
    }

    public void setIntegralname(String integralname) {
        this.integralname = integralname == null ? null : integralname.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}