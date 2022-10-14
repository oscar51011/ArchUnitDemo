package com.archUnit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DemoTransactionService {

	public void demoTransationSerivce() {
		System.out.println("test");
	}
}
