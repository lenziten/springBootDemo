package com.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.User;
import com.service.DemoComponent;
import com.service.UserService;

@Controller
@RequestMapping("/exit")
public class CloseController {
	
	private Logger log = LoggerFactory.getLogger(CloseController.class);
	
    @Autowired
    private ApplicationContext appContext;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private DemoComponent demoComponent;
	
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String test(HttpServletRequest request,HttpServletResponse response){
//    	System.out.println(userService.queryById("244B6AC3-66D9-4EE0-ACD1-C8061FD0631D").get("user_id"));
//    	return userService.getOne();
//    	return (String) userService.queryById("0A7B50C6-B27E-47E2-AC3D-FA68298A8D0D").get("user_id");
//    	return demoComponent.getDemo();
//    	response.sendRedirect("in");
    	return "forward:/index.jsp";
    }
    

    @ResponseBody
    @RequestMapping(value="getDate",method=RequestMethod.GET)
    public Date getDate() {
    	Date result = userService.getDate();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ssss");
    	log.debug("debugging msg : now is " + sdf.format(result));
    	return result;
    }
    
    @RequestMapping("/shutDown")
	public String shutDownBoot(){
    	int result = SpringApplication.exit(appContext);
		return String.valueOf(result);
	}

}
