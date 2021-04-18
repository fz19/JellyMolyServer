package com.jellymoly.server.service;

public interface UserService {
	UserVO get(long seq) throws Exception;

	void add(UserVO user) throws Exception;
}
