package com.tcs.weatherforecast.utility;

public class WeatherForecastConstants {

	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	public static final int EXPIRE = 10060;
	public static final int CONNECTION_TIME_OUT = 3;
	public static final int SOCKET_TIME_OUT = 4;
	public static final int EXCEPTION = 5;

	public static final String APIKEY = "26745e108e4f0a6c61412cbe28636be7";

	public static final String weatherForecastUrl = "https://api.forecast.io/forecast/"+ APIKEY;
	
	
}
