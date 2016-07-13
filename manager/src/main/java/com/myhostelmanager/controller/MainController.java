package com.myhostelmanager.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myhostelmanager.form.LoginForm;
import com.myhostelmanager.form.NewTenantForm;
import com.myhostelmanager.service.BlockService;
import com.myhostelmanager.service.LoginService;
import com.myhostelmanager.validator.LoginValidator;

@Controller
public class MainController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private BlockService blockService;
	
	Logger logger=LoggerFactory.getLogger(MainController.class);

	/*-------------- Login ---------------*/
	@RequestMapping(value="/index", method=RequestMethod.GET)
	private ModelAndView index(){
		logger.info("Redirecting from Index page");
		return new ModelAndView("redirect:login.LoRe");	
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	private ModelAndView showLoginForm(@ModelAttribute("loginForm") LoginForm loginForm, ModelMap model,HttpServletRequest request){
		logger.info("Redirecting to Login page");
		model.addAttribute("loginForm");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	private ModelAndView Signin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap model){
		logger.info("Uid:{}  pwd:{}", loginForm.getUid(), loginForm.getPwd());
		ModelAndView modelView=null;
		LoginValidator loginValidator = new LoginValidator();
		loginValidator.validateUser(loginForm, result);
		if(result.hasErrors()){
			logger.info("Has Errors");
			modelView=new ModelAndView("login");
		}else{
			logger.info("before isUserValid");
			boolean b = loginService.isUserValid(loginForm.getUid(), loginForm.getPwd());
			if(b){
				logger.info("Getting Hostel Id.");
				String hostelId=loginService.getHostelId(loginForm.getUid(), loginForm.getPwd());
				logger.info("Hostel Id:{} ", hostelId);
				model.addAttribute("hostelId", hostelId);
				logger.info("Getting Hostel Name.");
				model.addAttribute("hostelName", loginService.getHostelName(hostelId));
				logger.info("Getting Block Names");
				Map<String, String> blockNamesMap = blockService.getBlockIdNames(hostelId);
				model.addAttribute("BlockNames", blockNamesMap);
				if(blockNamesMap.size()==1){
					logger.info("Redirecting to Options page");
					modelView=new ModelAndView("options");
				}else{
					logger.info("Redirecting to BlockHome page");
					modelView=new ModelAndView("BlockHome");				
				}
			}
			else{
				logger.info("In valid User");
				model.addAttribute("status","In Valid User");
				modelView=new ModelAndView("login");
			}
		}
		return modelView;
	}
	
	/*------------------- Sign Up ------------------------*/
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	private String signUp(){
		logger.info("Redirecting to Sign Up");
		return "signup";	
	}
	
	/*-------------- Options ----------------------------*/
	
	@RequestMapping(value="/options", method=RequestMethod.GET)
	private ModelAndView options(HttpServletRequest request, ModelMap model){
		logger.info("Options method invoked.");
		String bId=request.getParameter("bId");
		String bName=request.getParameter("bName");
		logger.info("bId:{} and bName:{}",bId,bName);
		model.addAttribute("bId", bId);
		model.addAttribute("hostelName", bName);
		logger.info("Block Name:{}",bName);
		return new ModelAndView("options");
	}
	
	/*--------------- New Tenant -------------------------*/
	@RequestMapping(value="/addTenant", method=RequestMethod.GET)
	private ModelAndView newTenant(@ModelAttribute("newTenant") NewTenantForm newTenantForm, BindingResult result, ModelMap model, HttpServletRequest request ){
		logger.info("Options method invoked.");
		String bId=request.getParameter("bId");
		String bName=request.getParameter("bName");
		logger.info("bId:{} and bName:{}",bId,bName);
		model.addAttribute("bId", bId);
		model.addAttribute("hostelName", bName);
		List<String> roomNos = blockService.getRooms(bId);
		model.addAttribute("roomNos", roomNos);
		logger.info("Room Nos added to List.");
		logger.info("Redirecting to newTenant.");
		return new ModelAndView("newTenant");
	}
}
