package com.myhostelmanager.validator;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myhostelmanager.form.LoginForm;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object arg0, Errors errors) {
		
	}
	
	public void validateUser(LoginForm loginForm, Errors errors){
		System.out.println("IN validator");
		if(loginForm.getUid().isEmpty() || loginForm.getUid()==null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uid", "required.uid", "Enter UserName!");
		}else{
			Pattern pattern=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher=pattern.matcher(loginForm.getUid());
			if(!matcher.matches()){
				errors.rejectValue("uid", "uid.incorrect","Enter Valid UserName");
			}
		}
		if(loginForm.getPwd().isEmpty() || loginForm.getPwd()==null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required.pwd", "Enter Password!");
		}
//		if((!loginForm.getUid().isEmpty() && loginForm.getUid()!=null)&&(!loginForm.getPwd().isEmpty() && loginForm.getPwd()!=null)){
//			Iterator<LoginForm> itr=users.iterator();
//			while(itr.hasNext()){
//				LoginForm log=new LoginForm();
//				log=itr.next();
//				if(loginForm.getUid().equals(log.getUid()) && loginForm.getPwd().equals(log.getPwd())){
//				}else{
//						errors.rejectValue("username","username.incorrect","Enter Valid Username and Passowrd!");
//				}
//			}
		}		
	}

