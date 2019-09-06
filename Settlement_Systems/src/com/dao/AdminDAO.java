package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.pojos.Trade;

public interface AdminDAO {

	
	boolean inputTrade() ;
	boolean settleTrade() ;
	List<Trade> findAllTrades();
	boolean declareAction() ;
	
	
	
}
