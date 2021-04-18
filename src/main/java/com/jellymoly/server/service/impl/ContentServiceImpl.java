package com.jellymoly.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jellymoly.server.service.ContentService;
import com.jellymoly.server.service.ListFilterVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("contentService")
public class ContentServiceImpl extends EgovAbstractServiceImpl implements ContentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContentServiceImpl.class);
	
	@Resource(name = "contentMapper")
	private ContentMapper contentDAO;
	
	@Override
	public List<?> selectList(ListFilterVO filterVO) throws Exception {
		return contentDAO.selectList(filterVO);
	}
	
	@Override
	public int selectListCount(ListFilterVO filterVO) {
		return contentDAO.selectListCount(filterVO);
	}
	
}
