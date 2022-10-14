package com.archUnit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.archUnit.dao.DemoDao;

/**
 * 測試用Service
 * @author oscar51011
 *
 */
@Service
public class DemoService {

	@Autowired
	private DemoDao demoDao;
	
	public String demoService() {
		return demoDao.getDemoString();
	}
	
	@Transactional
	public String demoTransactionalService() {
		return demoDao.getDemoString();
	}
	
	/**
	 * 拋出 incorrect input data 的 exception
	 * @param positiveNumber
	 * @throws Exception
	 */
	public void demoExceptionService(int positiveNumber) throws Exception {		
		if(positiveNumber < 0) {
			// 錯誤情境
			throw new Exception("test error case");
			// 正確情境
			// throw new IllegalArgumentException("test error case");
		}
	}
}
