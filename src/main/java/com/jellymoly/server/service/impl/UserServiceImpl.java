package com.jellymoly.server.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jellymoly.server.service.User;
import com.jellymoly.server.service.UserService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("userService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSampleServiceImpl.class);
	@Resource(name = "userMapper")
	private UserMapper userDAO;
	
	
	@Override
	public User get(long seq) throws Exception {
		User user = userDAO.selectUser(seq);
		if (user == null)
			throw processException("info.nodata.msg");
		return user;
	}

}
