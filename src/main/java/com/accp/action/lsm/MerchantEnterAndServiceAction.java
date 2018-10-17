package com.accp.action.lsm;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.lsm.MerchantEnterAndServiceBiz;
import com.accp.pojo.Languagetype;
import com.accp.pojo.Majortype;
import com.accp.pojo.Servicedes;
import com.accp.pojo.Servicelevel;
import com.accp.pojo.Servicetype;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.util.file.Upload;
import com.accp.vo.lsm.ServiceDetailInfo;
import com.accp.vo.lsm.ServiceMerchantInfo;
import com.accp.vo.lsm.ServiceSelect;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/lsm")
public class MerchantEnterAndServiceAction {
	// 文件上传本地路径
	private final static String UPLOADED_FOLDER = "C://upload/lsm/";
	
	@Autowired
	private MerchantEnterAndServiceBiz biz;
	
	/**
	 * 商家入驻MVC地址
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("merchantEnterUrl")
	public String merchantEnterUrl(Model model,HttpSession session) {
		//User user = (User)session.getAttribute("USER");	//登录用户对象
		//Integer userMoney = user.getUsermoney();	//用户金币
		List<Servicetype> servicetypeList = biz.queryServiceType(null, null);	//获取服务类别
		List<Languagetype> languagetypeList = biz.queryLanguagetype();	//获取服务语言
		List<Majortype> majortypeList = biz.queryMajortype();	//获取擅长专业
		List<Sharea> shareaList = biz.querySharea(null,false);	//获取国家
		List<Sharea> liveCityList = biz.querySharea(2,false);	//获取韩国城市集合
		model.addAttribute("servicetypeList", servicetypeList);	//将服务类别集合存入request
		model.addAttribute("languagetypeList", languagetypeList); //将服务语言集合存入request
		model.addAttribute("majortypeList", majortypeList); //将擅长专业集合存入request
		model.addAttribute("shareaList",shareaList);	//将国家集合存入request
		model.addAttribute("liveCityList",liveCityList);	//将韩国城市集合存入request
		model.addAttribute("bond",biz.queryBond());	//将商家入驻需缴纳保证金额大小存入request
		model.addAttribute("userMoney",500);	//将用户金额存入request
		return "sjrz-txzl";
	}
	/**
	 * 商家入驻
	 * @return
	 */
	@PostMapping("merchantEnter")
	public String merchantMove(HttpSession session,User user,String serviceID,MultipartFile shopimgData,MultipartFile identitypositiveimgData,MultipartFile identitynegativeimgData,MultipartFile identityhandimgData) {
		System.out.println(JSON.toJSONString(user));
		session.setAttribute("USER", new User());
		User loginUser = (User)session.getAttribute("USER");	//登录用户
		loginUser.setUsermoney(500);
		loginUser.setUserid(18);
		float bond = biz.queryBond();	//入驻缴纳保证金金额要求
		if(loginUser.getUsermoney()>=bond) {	//如果当前登录用户的金额足够缴纳保证金
			if(serviceID.split(",").length==2) {	//如果用户选择的服务类别为两个
				user.setFirstserviceid(Integer.parseInt(serviceID.split(",")[0]));
				user.setSecondserviceid(Integer.parseInt(serviceID.split(",")[1]));	
			}else {
				user.setFirstserviceid(Integer.parseInt(serviceID));
			}
			try {
				String shopimgDataFName = Upload.saveFile(shopimgData);
				String identitypositiveimgDataFName = Upload.saveFile(identitypositiveimgData);
				String identitynegativeimgDataFName = Upload.saveFile(identitynegativeimgData);
				String identityhandimgDataFName = Upload.saveFile(identityhandimgData);
				user.setShopimg(shopimgDataFName);	//设置数据库存储图片路径
				user.setIdentitypositiveimg(identitypositiveimgDataFName);
				user.setIdentitynegativeimg(identitynegativeimgDataFName);
				user.setIdentityhandimg(identityhandimgDataFName);
				user.setUserid(loginUser.getUserid());//当前登录用户编号赋给修改对象
			} catch (IllegalStateException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			biz.merchantMove(user,bond);	//商家入驻
			return "sjrz-shzl";
		}else {
			System.out.println("金额不足！");
			return "redirect:/Public/error/500.html";
		}
	}
	


	/**
	 * 查询地址api
	 * @param pid
	 * @return
	 */
	@GetMapping("api/querySharea")
	@ResponseBody
	public List<Sharea> querySharea(Integer pid){
		return biz.querySharea(pid,false);
	}
	/**
	 * 点击服务详情跳转对应详情MVC地址
	 * @param htmlUrl
	 * @param sid
	 * @param uid
	 * @return
	 */
	@GetMapping("serviceDetailUrl")
	public String serviceDetailUrl(Model model,String htmlUrl,Integer sid,Integer uid) {
		System.out.println("进入方法"+htmlUrl);
		//查询发布服务的商家信息
		ServiceMerchantInfo serMerchantObj = biz.queryServiceMerchantInfo(uid,sid);
		//查询服务信息
		ServiceDetailInfo serDetailObj = biz.queryServiceDetailInfo(sid);
		serDetailObj.setSerDesList(biz.queryServiceDes(sid));
		//评价查询
		//同城服务查询
		//广告查询
		System.out.println(JSON.toJSONString(serDetailObj));
		model.addAttribute("serMerchantObj",serMerchantObj);
		model.addAttribute("serDetailObj",serDetailObj);
		return htmlUrl;
	}
	/**
	 * 点击服务跳转对应MVC地址
	 * @param htmlUrl 跳转的网页名称
	 * @param stid	服务类别编号
	 * @return
	 */
	@GetMapping("serviceUrl")
	public String serviceUrl(String htmlUrl,Integer stid,Model model) {
		//查询国家
		List<Sharea> countryList = biz.querySharea(null, false);	
		//根据一级服务类别获取子类别
		List<Servicetype> serTypeList = biz.queryServiceType(stid, 1);
		//根据一级服务类别获取级别
		List<Servicelevel> serLevelList = biz.queryServicelevel(stid);
		model.addAttribute("countryList",countryList);	//将国家存入request
		model.addAttribute("serTypeList",serTypeList);	//将当前一级服务类别的子类别存入request
		model.addAttribute("serLevelList",serLevelList);//将当前一级服务类别的级别存入request
		return htmlUrl;
	}

	/**
	 * 根据服务列表条件查询服务
	 * @return
	 */
	@GetMapping("api/queryServices")
	@ResponseBody
	public PageInfo queryServices(String objJSON,int num,int size){
		System.out.println(JSON.toJSONString(objJSON));
		ServiceSelect obj = JSON.parseObject(objJSON,ServiceSelect.class);
		//开始时间
		String startDate= obj.getStartDate();
		startDate = startDate!=null&&startDate!=""?startDate+" 00:00:00":null;
		//结束时间
		String endDate= obj.getEndDate();
		endDate = endDate!=null&&endDate!=""?endDate+" 23:59:59":null;
		obj.setStartDate(startDate);
		obj.setEndDate(endDate);
		return biz.queryServices(obj, num, size);
	}
	/**
	 * 查询对应服务类别下的子类别
	 * @param stpid
	 * @return
	 */
	@GetMapping("api/queryServiceTypeChild")
	@ResponseBody
	public List<Servicetype> queryServiceTypeChild(Integer stpid){
		return biz.queryServiceType(stpid, 1);
	}
	/**
	 * 查询城市
	 * @param areaid
	 * @return
	 */
	@GetMapping("api/queryCity")
	@ResponseBody
	public List<Sharea> queryCity(Integer areaid){
		return biz.querySharea(areaid, true);
	}
	
}
