package com.jellymoly.server.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jellymoly.server.service.ContentService;
import com.jellymoly.server.service.ContentVO;
import com.jellymoly.server.service.EgovSampleService;
import com.jellymoly.server.service.ListFilterVO;
import com.jellymoly.server.service.UserVO;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;

import com.jellymoly.server.service.UserService;

@Controller
public class MainController {
	@Resource
	private EgovSampleService service;
	@Resource
	private UserService userService;
	@Resource
	private ContentService contentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="/user.do", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String UserProfile(@RequestParam("no") long seq)
	{
		JSONObject response = new JSONObject();
		response.put("code", 9999);
		response.put("message", "오류가 발생했습니다.");
		try {
			UserVO user = userService.get(seq);

			response.put("user", new JSONObject(user));
			response.put("code", 0);
			response.put("message", "");
		} catch (EgovBizException e) {
			e.printStackTrace();
			response.put("code", 800);
			response.put("message", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return response.toString();
	}
	
	@RequestMapping(value="/newUser.do", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String NewUser(UserVO user)
	{
		JSONObject response = new JSONObject();
		response.put("code", 9999);
		response.put("message", "오류가 발생했습니다.");
		
		try {
			userService.add(user);
			
			response.put("code", 0);
			response.put("message", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return response.toString();
	}
	
	@RequestMapping(value="/contentList.do", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String ContentList(HttpServletRequest request)
	{
		JSONObject response = new JSONObject();
		response.put("code", 9999);
		response.put("message", "오류가 발생했습니다.");
		
		try {
			ListFilterVO filter = new ListFilterVO();
			
			if (request.getParameter("page") != null)
				filter.setPageIndex( Integer.parseInt(request.getParameter("page")) );
			
			int count = contentService.selectListCount(filter);
			List<ContentVO> list = (List<ContentVO>) contentService.selectList(filter);
			
			JSONArray json_list = new JSONArray();
			for (ContentVO row : list) {
				json_list.put(new JSONObject(row));
			}
			
			response.put("count", count);
			response.put("list", json_list);
			response.put("code", 0);
			response.put("message", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return response.toString();
	}
    
}
