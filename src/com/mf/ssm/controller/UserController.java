package com.mf.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mf.ssm.annotation.Authorization;
import com.mf.ssm.config.ResultStatus;
import com.mf.ssm.log.Logger;
import com.mf.ssm.model.ResultModel;
import com.mf.ssm.pojo.User;
import com.mf.ssm.pojo.UserToken;
import com.mf.ssm.service.UserService;
import com.mf.ssm.token.authorization.manager.TokenManager;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

import net.sf.json.JSONArray;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private TokenManager tokenManager;
	 

	//==============================================PC========================================
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value="/jumpToLogin", method=RequestMethod.GET)
	 public String jumpToLogin() throws Exception {
		 logger.info("jumpToLogin-->index->/jumpToLogin is start");
		 System.out.print("^^^^^^^^^^^^^/indexJumpToLogin^^^^^^^^^^^^^^^^^^^^^");
		 return "login";
	 }
	 
//	 @RequestMapping(value="/loginPc",method=RequestMethod.POST)
//	 @ApiOperation(value = "pc��¼")
//	 public String login(User user,Model model) throws Exception {
//		 logger.info("login-->/loginPc is start");
//		 System.out.print("^^^^^^^^^^^^^/loginPc^^^^^^^^^^^^^^^^^^^^^");
//		 user=userService.checkLogin(user.getUsername(), user.getPassword());
//		 if(user!=null){
//			 model.addAttribute(user);
//			 return "welcome";// ·�� WEB-INF/pages/welcome.jsp            
//		 }
//		 return "error";
//	 }
	 
//	 @RequestMapping(value="/loginPc",method=RequestMethod.POST)
//	 @ApiOperation(value = "pc��¼")
//	 public ModelAndView login(User user,Model model) throws Exception {
//		 logger.info("login-->/loginPc is start");
//		 System.out.print("^^^^^^^^^^^^^/loginPc^^^^^^^^^^^^^^^^^^^^^");
//		 user=userService.checkLogin(user.getUsername(), user.getPassword());
//		 if(user!=null){
//			 ModelAndView mode = new ModelAndView("welcome");
//			 mode.addObject("userName", user.getUsername());
//			 
//			 model.addAttribute(user);
//			 return mode;// ·�� WEB-INF/pages/welcome.jsp            
//		 }
//		 return null;
//	 }
	 

	
	 @RequestMapping(value="/loginPc",method=RequestMethod.POST)
	 @ApiOperation(value = "pc��¼")
	 public String login(User user, Model model) throws Exception {
		 logger.info("login-->/loginPc is start");
		 System.out.print("^^^^^^^^^^^^^/loginPc^^^^^^^^^^^^^^^^^^^^^");
		 user=userService.checkLogin(user.getUsername(), user.getPassword());
		 if(user!=null){
			 //ModelAndView mode = new ModelAndView("welcome");
			 //mode.addObject("userName", user.getUsername());
			 
			 //model.addAttribute(user);
			 return "welcome";// ·�� WEB-INF/pages/welcome.jsp            
		 }
		 return "error";
	 }
	 
	 @RequestMapping(value="/getUserInfoPc",method=RequestMethod.GET)
	 @ApiOperation(value = "��ȡ�û���Ϣ�б�")
	 public ModelAndView getUserInfoPc() {
		 ModelAndView view= new ModelAndView(); 
		 List<User> userList = userService.getUserInfo();
		 view.addObject("userList", userList);
		 view.setViewName("welcome");
		 return view;
	 }
	 
//	 @RequestMapping(value="testAjax",method=RequestMethod.GET)
//	 @ResponseBody
//	 public Object testAjax(){
//	 	TestJson testJson=new TestJson();
//	 	testJson.setName("chenym");
//	 	return testJson;
//	 }
	 
	 @RequestMapping(value="/testAjax", method=RequestMethod.POST) 

	    public @ResponseBody Map<String,Object> testAjax(HttpServletRequest request,HttpServletResponse response) throws IOException{ 

	        System.out.println(request.getParameter("name")); 

	        System.out.println(request.getParameter("age"));

	        Map<String,Object> map = new HashMap<String,Object>(); 

	        map.put("name",request.getParameter("name")); 

	        map.put("age",request.getParameter("age"));

	        return map; 

	}
	 
//	 @RequestMapping(value="/testAjax",method=RequestMethod.GET)
//	 @ApiOperation(value = "��ȡ�û���Ϣ�б�")
//	 @ResponseBody
//	 public void testAjax() {
//		// User use = userService.findByUsername(username);
//		//���⹹��һ�����飬ʹ���ص�����Ϊjson���飬���ݸ�����Щ
////		 Map<String, Object> map2 = new HashMap<String, Object>();
////		 map2.put("id", String.valueOf(use.getId()));
////		 map2.put("name", use.getUsername());
////		 map2.put("password", use.getPassword());
////		 JSONArray json = JSONArray.fromObject(map2); 
////		 PrintWriter printWriter = null;
////		    try {
////		      printWriter = response.getWriter();
////		      printWriter.print(json);
////		    } catch (IOException ex) {
////		      //Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
////		    } finally {
////		      if (null != printWriter) {
////		        printWriter.flush();
////		        printWriter.close();
////		      }
////		    }
//	 }
	 
	 @ModelAttribute
	    public User addUser(User user){//
	        user.setUsername("wwwww" + user.getUsername());
	        return user;
	    }
	 
	 
	//==============================================MB========================================
//	 /**
//	  * 
//	  * @param username
//	  * @param password
//	  * @return
//	  * @throws Exception
//	  */
//	 @RequestMapping(value="/loginMb", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//	 @ApiOperation(value = "�ֻ���¼")
//	 public ResponseEntity<ResultModel> login(
//			 @RequestParam String username, @RequestParam String password) throws Exception {
//		 
//		 logger.debug("login-->/loginMb-->username=" + username + " password=" + password);
//		 System.out.print("^^^^^^^^^^^^^/loginMb^^^^^^^^^^^^^^^^^^^^^");
//
//		 User user = userService.findByUsername(username);
//		 // δע��/�������
//		 if (user == null ||!user.getPassword().equals(password)) {  //�������
//			 //��ʾ�û������������
//			 return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
//		 }
//	        //����һ��token�������û���¼״̬
//		 UserToken model = tokenManager.createToken(user.getId());
//		 
//		 logger.debug("loginTel-->model=" + model);
//		 return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
//	 }
	 
	 /**
	  * 
	  * @param username
	  * @param password
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="/loginMb", method = RequestMethod.GET)
	 @ApiOperation(value = "�ֻ���¼")
	 public ResponseEntity<ResultModel> login(@RequestParam Map<String,String> map) throws Exception {
		 
		 //logger.debug("login-->/loginMb-->username=" + username + " password=" + password);
		 System.out.print("^^^^^^^^^^^^^/loginMb^^^^^^^^^^^^^^^^^^^^^is start");
		 String username = "test";
		 String password = "123";
		 User user = userService.findByUsername(username);
		 // δע��/�������
		 if (user == null ||!user.getPassword().equals(password)) {  //�������
			 //��ʾ�û������������
			 return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
		 }
	        //����һ��token�������û���¼״̬
		 UserToken model = tokenManager.createToken(user.getId());
		 
		 logger.debug("loginTel-->model=" + model);
		 return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
	 }
	 
	 
	 
	 @RequestMapping(value="/getUserInfoMb", method = RequestMethod.POST)
	 @Authorization
	 @ApiOperation(value = "��ȡ�û���Ϣ")
	 @ApiImplicitParams({@ApiImplicitParam(name = "authorization", value = "authorization", 
	 								required = true, dataType = "string", paramType = "header"),})
	 public ResponseEntity<User> getUserInfo(@RequestParam String username){

		 logger.debug("getUserInfo-->/loginMb-->username=" + username);
		 System.out.print("^^^^^^^^^^^^^/getUserInfoMb^^^^^^^^^^^^^^^^^^^^^");
		 User userModel = userService.findByUsername(username);
		 return new ResponseEntity<>(userModel, HttpStatus.OK);
	 }
	 
	 
}
