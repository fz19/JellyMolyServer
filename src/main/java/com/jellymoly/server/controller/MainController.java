package com.jellymoly.server.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class MainController {
	@Resource
	private EgovSampleService service;

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
