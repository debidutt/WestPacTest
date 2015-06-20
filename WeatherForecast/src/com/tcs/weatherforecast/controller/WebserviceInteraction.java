/*
 * This class is used to perform http post operations for fetching data from server
 */

package com.tcs.weatherforecast.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.HeterogeneousExpandableList;

import com.tcs.weatherforecast.utility.WeatherForecastConstants;

public class WebserviceInteraction {

	private static final int CONN_TIMEOUT = 60000;
	private static final int SO_TIMEOUT = 60000;

	public String WebserviceInteractionService(Context context, String request) {
		String strResult = null;
		try {

			Log.d("Request", WeatherForecastConstants.weatherForecastUrl
					+ request);

			HttpGet httpget = new HttpGet(
					WeatherForecastConstants.weatherForecastUrl + request);

			httpget.setHeader("Accept-Encoding", "gzip");

			HttpParams httpParameters = new BasicHttpParams();

			HttpConnectionParams.setConnectionTimeout(httpParameters,
					CONN_TIMEOUT);
			HttpConnectionParams.setSoTimeout(httpParameters, SO_TIMEOUT);
			HttpClient httpclient = new DefaultHttpClient(httpParameters);

			HttpResponse httpResponse = httpclient.execute(httpget);

			InputStream inputStream = httpResponse.getEntity().getContent();

			Header contentEncoding = httpResponse
					.getFirstHeader("Content-Encoding");

			if (contentEncoding != null
					&& contentEncoding.getValue().equalsIgnoreCase("gzip")) {
				inputStream = new GZIPInputStream(inputStream);
				strResult = convertInputStreamToString(inputStream);
			}

		} catch (ConnectException e) {
			strResult = null;
		} catch (ConnectTimeoutException e) {
			strResult = null;
		} catch (SocketTimeoutException e) {
			strResult = null;
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return strResult;
	}

	/**
	 * This function converts the stream returned from the webservice to a
	 * String format
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;
		inputStream.close();
		return result;
	}

}
