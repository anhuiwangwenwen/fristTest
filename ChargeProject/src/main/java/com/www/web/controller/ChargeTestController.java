package com.www.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.www.contants.Contants;
import com.www.pojo.User;
import com.www.user.service.UserService;

/***
 * ��������ҳ��controller
 * @author usb9usb
 *
 */
@Controller
@RequestMapping("/chargetest")
public class ChargeTestController {
	private Log logger = LogFactory.getLog(ChargeTestController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		logger.info("�򿪳�����ʼ����......");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chargeTest/startTestPage");
		return mv;
	}
	
	//�û�ɨ���¼
	@RequestMapping("login")
	public JSONObject loginUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		String workcode = request.getParameter("workcode");
		if(workcode==null || "".equals(workcode)) {
			json.put("result", Contants.ERROR);
			json.put("message", "workcode����Ϊ��");
		}
		try {
			User user = userService.getUserByWorkCode(workcode);
			if(user==null){
				json.put("result", Contants.ERROR);
				json.put("message", "workcodeΪ"+workcode+"�Ĳ���Ա������");
			}else{
				//�����ݴ���redis
				
				
				json.put("result", Contants.SUCCESS);
			}
		} catch (Exception e) {
			logger.error("userService.getUserByWorkCode�쳣"+e);
		}
		
		return json;
	}
}
