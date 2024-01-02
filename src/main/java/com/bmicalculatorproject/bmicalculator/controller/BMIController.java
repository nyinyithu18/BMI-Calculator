package com.bmicalculatorproject.bmicalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bmicalculatorproject.bmicalculator.model.BmiModel;
import com.bmicalculatorproject.bmicalculator.service.serviceimpl.BmiServiceImpl;

@Controller
public class BMIController {

	@Autowired
	private BmiServiceImpl bmiServiceImpl;
	
	@RequestMapping(value = "/bmidata", method = RequestMethod.GET)
	public ModelAndView start(@RequestParam (name = "weight")String weight, @RequestParam (name = "height")String height, @RequestParam (name = "inches")String inches) {
		
		BmiModel bmiModel = bmiServiceImpl.resultBmi(weight,height,inches);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("bmiModel",bmiModel);
		return model;
	}
}
