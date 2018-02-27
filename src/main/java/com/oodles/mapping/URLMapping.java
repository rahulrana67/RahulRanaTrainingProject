package com.oodles.mapping;

public class URLMapping 
{
	public static final String ACCOUNTS_API_V1 ="/v1";
	
	//USER
	
	public static final String ADD_USER = ACCOUNTS_API_V1 +"/add_user";
	public static final String GET_USER = ACCOUNTS_API_V1 +"/get_user";
	public static final String UPDATE_USER=ACCOUNTS_API_V1+"/update_user";
	
	
	//EXCHANGE
	
	public static final String ADD_EXCHANGE=ACCOUNTS_API_V1+"/add_exchange";
	public static final String GET_EXCHANGE=ACCOUNTS_API_V1+"/get_exchange";
	
	//MARKET
	
	public static final String SAVE_MARKET=ACCOUNTS_API_V1+"/add_market";
	public static final String GET_MARKET=ACCOUNTS_API_V1+"/get_market";
	
}