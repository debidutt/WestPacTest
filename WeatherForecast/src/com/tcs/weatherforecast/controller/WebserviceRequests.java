/*
 * This class is used to create request get to server
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
		
		// Making a web service interaction call
		
		String strResult = new WebserviceInteraction().WebserviceInteractionService(mContext, request);
		
		return strResult;
	}

}
