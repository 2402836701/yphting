package com.accp.biz.lsm;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.lsm.MerchantEnterAndServiceDao;
import com.accp.pojo.Languagetype;
import com.accp.pojo.Majortype;
import com.accp.pojo.Servicedes;
import com.accp.pojo.Servicelevel;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.vo.lsm.ServiceDetailInfo;
import com.accp.vo.lsm.ServiceMerchantInfo;
import com.accp.vo.lsm.ServiceSelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class MerchantEnterAndServiceBiz {

	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	@Autowired
	private MerchantEnterAndServiceDao dao;
	
	/**
	 * 商家入驻
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int merchantMove(User user,float bond) {
		return dao.merchantMove(user,bond);
	}
	/**
	 * 根据服务列表条件查询服务
	 * @return
	 */
	public PageInfo queryServices(ServiceSelect obj,int num,int size){
		PageHelper.startPage(num, size);
		return new PageInfo(dao.queryServices(obj));
	}
	/**
	 * 查询服务类别
	 * @param stpid 服务类别父级编号，为空则代表查询最高级服务类别
	 * @return
	 */
	public List<Servicetype> queryServiceType(Integer stpid,Integer selectNum){
		return dao.queryServiceType(stpid, selectNum);
	}
	/**
	 * 根据一级服务类别查询对应的级别
	 * @param stpid
	 * @return
	 */
	public List<Servicelevel> queryServicelevel(Integer stid){
		return dao.queryServicelevel(stid);
	}
	/**
	 * 查询服务语言
	 * @return
	 */
	public List<Languagetype> queryLanguagetype(){
		return dao.queryLanguagetype();
	}
	/**
	 * 查询擅长专业
	 * @return
	 */
	public List<Majortype> queryMajortype(){
		return dao.queryMajortype();
	}
	/**
	 * 查询中韩行政地区地址信息
	 * @param pid 地址编号
	 * @return
	 */
	public List<Sharea> querySharea(Integer pid,boolean flag){
		return dao.querySharea(pid,flag);
	}
	/**
	 * 查询商家入驻需缴纳保证金金额
	 * @return
	 */
	public float queryBond() {
		return dao.queryBond();
	}
	/**
	 * 查询服务的商家信息
	 */
	public ServiceMerchantInfo queryServiceMerchantInfo(Integer uid,Integer sid) {
		return dao.queryServiceMerchantInfo(uid,sid);
	}
	/**
	 * 查询服务详情信息
	 * @param sid 服务编号
	 * @return
	 */
	public ServiceDetailInfo queryServiceDetailInfo(Integer sid) {
		return dao.queryServiceDetailInfo(sid);
	}
	/**
	 * 查询服务描述
	 * @param sid 服务编号
	 * @return
	 */
	public List<Servicedes> queryServiceDes(Integer sid){
		return dao.queryServiceDes(sid);
	}
}
