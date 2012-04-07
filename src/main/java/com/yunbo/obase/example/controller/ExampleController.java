package com.yunbo.obase.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yunbo.obase.example.model.ExampleModel;
import com.yunbo.obase.core.controller.BaseRestSpringController;

@Controller
@RequestMapping("/example")
public class ExampleController extends BaseRestSpringController<ExampleModel, java.lang.Long> {

	@Override
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ExampleModel model) {
		System.out.println("index");
		return new ModelAndView("/example/index");
	}

	@Override
	public ModelAndView show(@PathVariable java.lang.Long id) throws Exception {
		System.out.println("get: " + id);
		return new ModelAndView("/example/view");
	}
}
