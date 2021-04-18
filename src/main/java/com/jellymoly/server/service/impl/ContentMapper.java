package com.jellymoly.server.service.impl;

import java.util.List;

import com.jellymoly.server.service.ContentVO;
import com.jellymoly.server.service.ListFilterVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("contentMapper")
public interface ContentMapper {
	/**
	 * 컨텐츠 목록 조회
	 * @param filterVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectList(ListFilterVO filterVO) throws Exception;
	
	/**
	 * 컨텐츠 총 개수 조회
	 * @param filterVO
	 * @return
	 */
	int selectListCount(ListFilterVO filterVO);
}
