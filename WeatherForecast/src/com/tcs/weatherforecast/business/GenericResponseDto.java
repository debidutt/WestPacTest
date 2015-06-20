package com.tcs.weatherforecast.business;

import org.json.JSONException;
import org.json.JSONObject;

import com.tcs.weatherforecast.utility.Utilities;

public class GenericResponseDto {

	private String latitude;
	private String longitude;
	private String timezone;
	private String offset;
	private DataDto currently;
	private HourlyDto hourly, daily;
	private FlagsDto flags;
	private AlertDto alert;
	Utilities utility;

	public GenericResponseDto(JSONObject jObj) {
		// TODO Auto-generated constructor stub

		try {

			if (jObj.has("latitude"))
				this.setLatitude(jObj.getString("latitude"));
			else
				this.setLatitude("");

			if (jObj.has("longitude"))
				this.setLongitude(jObj.getString("longitude"));
			else
				this.setLongitude("");
			if (jObj.has("timezone"))
				this.setTimezone(jObj.getString("timezone"));
			else
				this.setTimezone("");

			if (jObj.has("offset"))
				this.setOffset(jObj.getString("offset"));
			else
				this.setOffset("");

			currently = new DataDto(jObj.getJSONObject("currently"));
			hourly = new HourlyDto(jObj.getJSONObject("hourly"));
			daily = new HourlyDto(jObj.getJSONObject("daily"));
			flags = new FlagsDto(jObj.getJSONObject("flags"));

			if (jObj.has("Alert"))
				alert = new AlertDto(jObj.getJSONObject("Alert"));
			else {
				alert = new AlertDto(new JSONObject().put("expires", +0L));
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public FlagsDto getFlags() {
		return flags.getFlagsDto();
	}

	public AlertDto getAlert() {
		return alert.getAlertDto();
	}

	public HourlyDto getDailyDto() {
		return daily;
	}

	public void setDailyDto(HourlyDto daily) {
		this.daily = daily;
	}

	public DataDto getCurrently() {
		return currently;
	}

	public void setCurrently(DataDto currently) {
		this.currently = currently;
	}

	public HourlyDto getHourlyDto() {
		return hourly;
	}

	public void setHourly(HourlyDto hourly) {
		this.hourly = hourly;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public DataDto getCurrentDto() {

		return currently.getCurrentDto();

	}

}
