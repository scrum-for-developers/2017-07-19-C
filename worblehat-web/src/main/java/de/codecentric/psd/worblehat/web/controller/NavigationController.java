package de.codecentric.psd.worblehat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.web.StartupMonitor;

/**
 * Controller for Navigation
 */
@Controller
//@PropertySource("classpath:config.properties")
public class NavigationController {
//	@Value("${application.version}")
//    private String applicationVersion;
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Model model) {
//		model.addAttribute("version", applicationVersion);
//		return "home";
//	}
	
	public String version = "";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("version", "Version: " + StartupMonitor.version);

		return "home";
	}
	
	
}
