/*
 * This class is used to hold generic functions used in different classes of the application
 */

package com.tcs.weatherforecast.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import org.json.JSONException;
import org.json.JSONObject;

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
	 * @return
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

	@SuppressLint("SimpleDateFormat")
	public String UnixToActual(Long unixSeconds) {

		Date date = new Date((unixSeconds) * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String formattedDate = sdf.format(date);

		return formattedDate;
	}

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

	public String checkJsonNoValue(JSONObject jsonObject, String tag,
			String dataType) {

		String returnValue = "";

		if (jsonObject.has(tag)) {
			try {
				returnValue = jsonObject.getString(tag);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			returnValue = "No Tags for " + tag;
		}

		return returnValue;
	}
}
