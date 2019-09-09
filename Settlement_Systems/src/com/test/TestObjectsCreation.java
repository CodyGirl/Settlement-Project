package com.test;

import com.dao.ObjectsCreation;

public class TestObjectsCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		(ObjectsCreation.findTrader()).forEach((a)->{
//			System.out.println(a);
//		});
		
		(ObjectsCreation.findEquity()).forEach((a)->{
			System.out.println(a);
		});

	}

}
