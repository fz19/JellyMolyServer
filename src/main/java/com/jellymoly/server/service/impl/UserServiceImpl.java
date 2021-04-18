package com.jellymoly.server.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jellymoly.server.service.UserVO;
import com.jellymoly.server.service.UserService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("userService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource(name = "userMapper")
	private UserMapper userDAO;
	
	
	@Override
	public UserVO get(long seq) throws Exception {
		UserVO user = userDAO.selectUser(seq);
		if (user == null)
			throw processException("info.nodata.msg");
		return user;
	}


	@Override
	public void add(UserVO user) throws Exception {
		userDAO.insert(user);
	}

}
