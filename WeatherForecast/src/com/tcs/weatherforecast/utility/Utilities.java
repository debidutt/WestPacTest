/*
 * This class is used to hold generic functions used in different classes of the application
 */

package com.tcs.weatherforecast.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;

public class Utilities {

	private Context mContext;
	

	public Utilities(Context context) {
		this.mContext = context;
	}

	/**
	 * This function is used to check if the device is online
	 * 
	 * @return boolean
	 */
	public boolean isNetworkOnline() {
		;
		ConnectivityManager conMan = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (conMan.getActiveNetworkInfo() != null
				&& conMan.getActiveNetworkInfo().isConnectedOrConnecting()) {
			return true;
		} else {

			return false;
		}
	}
	
	

	/**
	 * This function is used to convert a UNIX millisecond value calculated since 1970 
	 * to HH : mm a format
	 * @param unixSeconds
	 * @return
	 */
	
	@SuppressLint("SimpleDateFormat")
	public String UnixToActual(Long unixSeconds) {

		Date date = new Date((unixSeconds) * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String formattedDate = sdf.format(date);

		return formattedDate;
	}
	
	
	
	/**
	 * This function is used to iterate weather hashmap and check if the key value of weather hashmap 
	 * is same as the value passed by icon. if found return value is the color code associated 
	 * with the weather hashmap key
	 * 
	 * @param weather
	 * @param icon
	 * @return
	 */

	public String iterationAndCompare(HashMap<String, String> weather,
			String icon) {

		String colorCode = "";

		try {
			for (String key : weather.keySet()) {

				if (icon.equalsIgnoreCase(key)) {
					colorCode = weather.get(key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return colorCode;
	}
	

}
