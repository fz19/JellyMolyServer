package com.jellymoly.server.service.impl;

import com.jellymoly.server.service.User;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {
	User selectUser(long seq) throws Exception;
}
