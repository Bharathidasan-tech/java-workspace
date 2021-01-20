package com.personapi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.personapi.common.constant.PersonConstant;

/**
 * The Class ApiAccessController.
 *
 * @author Bharathidasan
 */
@RestController
public class ApiAccessController {
	
	/**
	 * Login page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value=PersonConstant.LOGIN_ACCESS,method=RequestMethod.GET)
	public ModelAndView loginPage() {		
		return new ModelAndView(PersonConstant.HOME_PAGE);
	}
	
	/**
	 * Logout page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value=PersonConstant.LOGOUT_ACTION,method=RequestMethod.GET)
	public ModelAndView logoutPage() {		
		return new ModelAndView("index");
	}
	
	/*
	 * @RequestMapping(value=PersonConstant.API_ACCESS,method=RequestMethod.GET)
	 * public ModelAndView homePage() { return new
	 * ModelAndView(PersonConstant.HOME_PAGE); }
	 */
	
	

}
