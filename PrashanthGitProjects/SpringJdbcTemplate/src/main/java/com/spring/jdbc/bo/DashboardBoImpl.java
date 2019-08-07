package com.spring.jdbc.bo;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.jdbc.controller.DashboardController;
import com.spring.jdbc.dao.DashboardDao;

@Component
public class DashboardBoImpl implements DashboardBo {
	private static Logger logger=Logger.getLogger(DashboardBo.class);
	@Autowired
	private DashboardDao dashDao;

	public List<Map<String, Object>> getDashboardData(String dname) {
		logger.info("getDashboardData() method entered0000000000000000000DashboardBoImpl");
		List<Map<String, Object>> list=dashDao.getDashboardData(dname);
		return list;
	}
	
}
