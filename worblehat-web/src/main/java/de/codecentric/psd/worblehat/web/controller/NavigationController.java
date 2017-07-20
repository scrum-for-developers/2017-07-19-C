package de.codecentric.psd.worblehat.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for Navigation
 */
@Controller
@PropertySource("classpath:config.properties")
public class NavigationController {
	@Value("${application.version}")
    private String applicationVersion;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("version", applicationVersion);
//		Object o = ((BindingAwareModelMap) model).get("version");
		return "home";
	}
	
	
}
