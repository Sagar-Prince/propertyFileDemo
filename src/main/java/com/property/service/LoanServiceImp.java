package com.property.service;

import com.property.dao.LoanDAO;
import com.property.demo.bo.CustomerBO;

public class LoanServiceImp implements LoanService {
	
	private LoanDAO dao;

	public LoanDAO getDao() {
		return dao;
	}

	public void setDao(LoanDAO dao) {
		this.dao = dao;
	}
	
	
	public float calclAmt(int cno, String cname, float pamt, float rate, float time) {
		
		//write b.logic
		float intramt=(pamt*rate*time)/100.0f;
		//use dao class parsistance logic.
		CustomerBO cbo=new CustomerBO();
		cbo.setCno(cno);
		cbo.setName(cname);
		cbo.setPamt(pamt);
		cbo.setIntramt(intramt);
        dao.insert(cbo);
		
		return intramt;
	}

}
