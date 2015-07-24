package com.skcc.scouter.sample.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skcc.scouter.sample.service.SampleService;

@Controller
@RequestMapping(value="/sample")
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Resource(name = "sampleService")
	SampleService sampleService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/getPoint")
	@ResponseBody
	public ModelAndView getPoint(@SuppressWarnings("rawtypes") @RequestBody Map rq)  {
		ModelAndView mav = new ModelAndView("jsonView");
		
		logger.debug("getPoint Requested : {}", rq);
		
		Object name = rq.get("name");
		
		Assert.notNull(name);
		Assert.isInstanceOf(String.class, name);
			
		Integer point = sampleService.getPoint((String)rq.get("name"));
		
		Assert.notNull(point);
		
		mav.addObject("point", point);
		
		return mav;
	}
		
}
