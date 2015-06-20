/*
 * This class is used to create request jsons to post to server
 */

package com.tcs.weatherforecast.controller;


import android.content.Context;
import android.util.Log;

public class WebserviceRequests {
	
	private Context mContext;
	
	public WebserviceRequests(Context context) {
		this.mContext = context;
	}
	
	
	public String getWeatherForecastData(String latitude,String longitude)
	{
	
		String request = "/"+latitude+","+longitude;
		
		Log.d("Calling", "getWeatherForecastData method");
		
		String strResult = new WebserviceInteraction().WebserviceInteractionService(mContext, request);
		
		return strResult;
	}

}
