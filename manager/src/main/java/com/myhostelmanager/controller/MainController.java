package com.myhostelmanager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myhostelmanager.form.LoginForm;
import com.myhostelmanager.service.BlockService;
import com.myhostelmanager.service.LoginService;
import com.myhostelmanager.validator.LoginValidator;

@Controller
public class MainController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private BlockService blockService;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	private ModelAndView index(){
		return new ModelAndView("redirect:login.LoRe");	
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	private ModelAndView showLoginForm(@ModelAttribute("loginForm") LoginForm loginForm, ModelMap model,HttpServletRequest request){
		model.addAttribute("loginForm");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	private ModelAndView Signin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap model){
		System.out.println("Uid "+loginForm.getUid()+ " " + loginForm.getPwd());
		ModelAndView modelView=null;
		LoginValidator loginValidator = new LoginValidator();
		loginValidator.validateUser(loginForm, result);
		if(result.hasErrors()){
			System.out.println("Has Errors");
			modelView=new ModelAndView("login");
		}
		System.out.println("before isUserValid");
		boolean b = loginService.isUserValid(loginForm.getUid(), loginForm.getPwd());
		if(b){
			String hostelId=loginService.getHostelId(loginForm.getUid(), loginForm.getPwd());
			System.out.println("Hostel: "+ hostelId);
			model.addAttribute("hostelId", hostelId);
			model.addAttribute("hostelName", loginService.getHostelName(hostelId));
//			blockService.getAllBlocks(hostelId);
			model.addAttribute("BlockNames", blockService.getBlockIdNames(hostelId));
			modelView=new ModelAndView("BlockHome");
		}else{
			modelView=new ModelAndView("login");
		}
		return modelView;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	private String signUp(){
		return "signup";	
	}
	
	
}
