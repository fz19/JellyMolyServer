package com.jellymoly.server.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jellymoly.server.service.EgovSampleService;
import com.jellymoly.server.service.SampleDefaultVO;
import com.jellymoly.server.service.SampleVO;
import com.jellymoly.server.service.User;
import com.jellymoly.server.service.UserService;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class MainController {
	@Resource
	private EgovSampleService service;
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/user.do")
	@ResponseBody
	public String UserProfile(HttpServletRequest request, ModelMap model)
	{
		try {
			long seq = 2;
			
			User user = userService.get(seq);
			if (user == null)
				return "null";
			
			return "OK:" + user.getName(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return "error";
	}

    @RequestMapping(value="/hello.do")
    @ResponseBody
    public String HelloPage(HttpServletRequest request, ModelMap model)
    {
    	try {
    		SampleDefaultVO filter = new SampleDefaultVO();
			List<SampleVO> list = (List<SampleVO>) service.selectSampleList(filter);
	    	return String.valueOf( list.size() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "error";
    }

    @RequestMapping(value="/list.do")
    @ResponseBody
    public String ListPage(HttpServletRequest request, ModelMap model)
    {
    	try {
    		SampleDefaultVO filter = new SampleDefaultVO();
			List<EgovMap> list = (List<EgovMap>) service.selectSampleList(filter);

			StringBuffer sb = new StringBuffer();
			for (EgovMap row : list) {
				sb.append(row.toString());
				sb.append("<br />");
			}
			
	    	return String.valueOf( sb.toString() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "error";
    }
    
}
