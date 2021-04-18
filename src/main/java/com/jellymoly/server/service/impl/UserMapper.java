package com.jellymoly.server.service.impl;

import com.jellymoly.server.service.UserVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {
	UserVO selectUser(long seq) throws Exception;

	void insert(UserVO user) throws Exception;
}
