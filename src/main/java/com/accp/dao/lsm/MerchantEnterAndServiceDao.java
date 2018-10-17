package com.accp.dao.lsm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

/**
 * 商家入驻和服务Dao层
 * @author lsm
 *
 */
public interface MerchantEnterAndServiceDao {
	/**
	 * 查询服务类别
	 * @param stpid 服务类别父级编号，为空则代表查询最高级服务类别
	 * @return
	 */
	public List<Servicetype> queryServiceType(@Param("stpid")Integer stpid,@Param("selectNum")Integer selectNum);
	/**
	 * 根据一级服务类别查询对应的级别
	 * @param stpid
	 * @return
	 */
	public List<Servicelevel> queryServicelevel(@Param("stid")Integer stid);
	/**
	 * 根据服务列表条件查询服务
	 * @return
	 */
	public List<Services> queryServices(@Param("obj")ServiceSelect obj);
	/**
	 * 查询服务语言
	 * @return
	 */
	public List<Languagetype> queryLanguagetype();
	/**
	 * 查询擅长专业
	 * @return
	 */
	public List<Majortype> queryMajortype();
	/**
	 * 查询中韩行政地区地址信息
	 * @param pid 地址编号
	 * @return
	 */
	public List<Sharea> querySharea(@Param("pid")Integer pid,@Param("flag")boolean flag);
	/**
	 * 商家入驻
	 * @return
	 */
	public int merchantMove(@Param("obj")User user,@Param("bond")float bond);
	/**
	 * 查询商家入驻需缴纳保证金金额
	 * @return
	 */
	public float queryBond();
	/**
	 * 查询服务的商家信息
	 */
	public ServiceMerchantInfo queryServiceMerchantInfo(@Param("uid")Integer uid,@Param("sid")Integer sid);
	/**
	 * 查询服务详情信息
	 * @param sid 服务编号
	 * @return
	 */
	public ServiceDetailInfo queryServiceDetailInfo(@Param("sid")Integer sid);
	/**
	 * 查询服务描述
	 * @param sid 服务编号
	 * @return
	 */
	public List<Servicedes> queryServiceDes(@Param("sid")Integer sid);
	
	
	
}
