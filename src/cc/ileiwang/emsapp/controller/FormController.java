package cc.ileiwang.emsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月7日 下午5:35:14
*/
@Controller
public class FormController {
	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		return formName;
	}
}
