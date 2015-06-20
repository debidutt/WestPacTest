package com.tcs.weatherforecast.business;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DataDto {
	private long time;
	private String summary;
	private String icon;
	private long sunriseTime;
	private long sunsetTime;
	private double moonPhase;
	private double nearestStormDistance;
	private double nearestStormBearing;
	private double precipIntensity;
	private double precipIntensityMax;
	private long precipIntensityMaxTime;
	private long precipIntensityTime;
	private double precipProbability;
	private String precipType;
	private double temperature;
	private double temperatureMin;
	private long temperatureMinTime;
	private double temperatureMax;
	private long temperatureMaxTime;
	private double apparentTemperature;
	private double apparentTemperatureMin;
	private long apparentTemperatureMinTime;
	private double apparentTemperatureMax;
	private long apparentTemperatureMaxTime;
	private double dewPoint;
	private double humidity;
	private double windSpeed;
	private double windBearing;
	private double visibility;
	private double cloudCover;
	private double pressure;
	private double ozone;

	public DataDto(JSONObject jsonObject) {

		// TODO Auto-generated constructor stub

		try {

			if (jsonObject.has("time"))
				this.setTime(jsonObject.getLong("time"));
			else
				this.setTime(+0L);

			if (jsonObject.has("summary"))
				this.setSummary(jsonObject.getString("summary"));
			else
				this.setSummary("");

			if (jsonObject.has("icon"))
				this.setIcon(jsonObject.getString("icon"));
			else
				this.setIcon("");

			if (jsonObject.has("sunriseTime"))
				this.setSunriseTime(jsonObject.getLong("sunriseTime"));
			else
				this.setSunriseTime(+0L);

			if (jsonObject.has("sunsetTime"))
				this.setSunsetTime(jsonObject.getLong("sunsetTime"));
			else
				this.setSunsetTime(+0L);

			if (jsonObject.has("moonPhase"))
				this.setMoonPhase(jsonObject.getDouble("moonPhase"));
			else
				this.setMoonPhase(0.00);

			if (jsonObject.has("nearestStormDistance"))
				this.setNearestStormDistance(jsonObject.getDouble("nearestStormDistance"));
			else
				this.setNearestStormDistance(0.00);
			
			if (jsonObject.has("nearestStormBearing"))
				this.setNearestStormBearing(jsonObject.getDouble("nearestStormBearing"));
			else
				this.setNearestStormBearing(0.00);
			
			if (jsonObject.has("precipIntensity"))
				this.setPrecipIntensity(jsonObject.getDouble("precipIntensity"));
			else
				this.setPrecipIntensity(0.00);

			if (jsonObject.has("precipIntensityMax"))
				this.setPrecipIntensityMax(jsonObject
						.getDouble("precipIntensityMax"));
			else
				this.setPrecipIntensityMax(0.00);

			if (jsonObject.has("precipIntensityMaxTime"))
				this.setPrecipIntensityMaxTime(jsonObject
						.getLong("precipIntensityMaxTime"));
			else
				this.setPrecipIntensityMaxTime(+0L);

			if (jsonObject.has("precipIntensityMaxTime"))
				this.setPrecipIntensityTime(jsonObject
						.getLong("precipIntensityMaxTime"));
			this.setPrecipIntensityTime(+0L);

			if (jsonObject.has("precipProbability"))
				this.setPrecipProbability(jsonObject
						.getDouble("precipProbability"));
			else
				this.setPrecipProbability(0.00);

			if (jsonObject.has("precipType"))
				this.setPrecipType(jsonObject.getString("precipType"));
			else
				this.setPrecipType("");

			if (jsonObject.has("temperature"))
				this.setTemperature(jsonObject.getDouble("temperature"));
			else
				this.setTemperature(0.00);

			if (jsonObject.has("apparentTemperature"))
				this.setApparentTemperature(jsonObject
						.getDouble("apparentTemperature"));
			else
				this.setApparentTemperature(0.00);

			if (jsonObject.has("apparentTemperatureMax"))
				this.setTemperatureMax(jsonObject
						.getDouble("apparentTemperatureMax"));
			else
				this.setTemperatureMax(0.00);

			if (jsonObject.has("apparentTemperatureMaxTime"))
				this.setTemperatureMaxTime(jsonObject
						.getLong("apparentTemperatureMaxTime"));
			else
				this.setTemperatureMaxTime(+0L);

			if (jsonObject.has("apparentTemperatureMin"))
				this.setTemperatureMin(jsonObject
						.getDouble("apparentTemperatureMin"));
			else
				this.setTemperatureMin(0.00);

			if (jsonObject.has("apparentTemperatureMinTime"))
				this.setTemperatureMinTime(jsonObject
						.getLong("apparentTemperatureMinTime"));
			else
				this.setTemperatureMinTime(+0L);

			if (jsonObject.has("apparentTemperatureMax"))
				this.setApparentTemperatureMax(jsonObject
						.getDouble("apparentTemperatureMax"));
			else
				this.setApparentTemperatureMax(0.00);

			if (jsonObject.has("apparentTemperatureMaxTime"))
				this.setApparentTemperatureMaxTime(jsonObject
						.getLong("apparentTemperatureMaxTime"));
			else
				this.setApparentTemperatureMaxTime(+0L);

			if (jsonObject.has("apparentTemperatureMin"))
				this.setApparentTemperatureMin(jsonObject
						.getDouble("apparentTemperatureMin"));
			else
				this.setApparentTemperatureMin(0.00);

			if (jsonObject.has("apparentTemperatureMinTime"))
				this.setApparentTemperatureMinTime(jsonObject
						.getLong("apparentTemperatureMinTime"));
			else
				this.setApparentTemperatureMinTime(+0L);

			if (jsonObject.has("dewPoint"))
				this.setDewPoint(jsonObject.getDouble("dewPoint"));
			else
				this.setDewPoint(0.00);

			if (jsonObject.has("humidity"))
				this.setHumidity(jsonObject.getDouble("humidity"));
			else
				this.setHumidity(0.00);

			if (jsonObject.has("windSpeed"))
				this.setWindSpeed(jsonObject.getDouble("windSpeed"));
			else
				this.setWindSpeed(0.00);

			if (jsonObject.has("windBearing"))
				this.setWindBearing(jsonObject.getDouble("windBearing"));
			else
				this.setWindBearing(0.00);

			if (jsonObject.has("visibility"))
				this.setVisibility(jsonObject.getDouble("visibility"));
			else
				this.setVisibility(0.00);

			if (jsonObject.has("cloudCover"))
				this.setCloudCover(jsonObject.getDouble("cloudCover"));
			else
				this.setCloudCover(0.00);

			if (jsonObject.has("pressure"))
				this.setPressure(jsonObject.getDouble("pressure"));
			else
				this.setPressure(0.00);

			if (jsonObject.has("ozone"))
				this.setOzone(jsonObject.getDouble("ozone"));
			else
				this.setOzone(0.00);

		} catch (JSONException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}

	public double getPrecipIntensityMax() {
		return precipIntensityMax;
	}

	public void setPrecipIntensityMax(double precipIntensityMax) {
		this.precipIntensityMax = precipIntensityMax;
	}

	public long getPrecipIntensityMaxTime() {
		return precipIntensityMaxTime;
	}

	public void setPrecipIntensityMaxTime(long precipIntensityMaxTime) {
		this.precipIntensityMaxTime = precipIntensityMaxTime;
	}

	public long getPrecipIntensityTime() {
		return precipIntensityTime;
	}

	public void setPrecipIntensityTime(long precipIntensityTime) {
		this.precipIntensityTime = precipIntensityTime;
	}

	public double getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public long getTemperatureMinTime() {
		return temperatureMinTime;
	}

	public void setTemperatureMinTime(long temperatureMinTime) {
		this.temperatureMinTime = temperatureMinTime;
	}

	public double getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public long getTemperatureMaxTime() {
		return temperatureMaxTime;
	}

	public void setTemperatureMaxTime(long temperatureMaxTime) {
		this.temperatureMaxTime = temperatureMaxTime;
	}

	public double getApparentTemperatureMin() {
		return apparentTemperatureMin;
	}

	public void setApparentTemperatureMin(double apparentTemperatureMin) {
		this.apparentTemperatureMin = apparentTemperatureMin;
	}

	public long getApparentTemperatureMinTime() {
		return apparentTemperatureMinTime;
	}

	public void setApparentTemperatureMinTime(long apparentTemperatureMinTime) {
		this.apparentTemperatureMinTime = apparentTemperatureMinTime;
	}

	public double getApparentTemperatureMax() {
		return apparentTemperatureMax;
	}

	public void setApparentTemperatureMax(double apparentTemperatureMax) {
		this.apparentTemperatureMax = apparentTemperatureMax;
	}

	public long getApparentTemperatureMaxTime() {
		return apparentTemperatureMaxTime;
	}

	public void setApparentTemperatureMaxTime(long apparentTemperatureMaxTime) {
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}

	public long getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(long sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public long getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(long sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

	public double getMoonPhase() {
		return moonPhase;
	}

	public void setMoonPhase(double moonPhase) {
		this.moonPhase = moonPhase;
	}

	public double getPrecipIntensity() {
		return precipIntensity;
	}

	public void setPrecipIntensity(double precipIntensity) {
		this.precipIntensity = precipIntensity;
	}

	public double getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(double precipProbability) {
		this.precipProbability = precipProbability;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(double apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}

	public double getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(double dewPoint) {
		this.dewPoint = dewPoint;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindBearing() {
		return windBearing;
	}

	public void setWindBearing(double windBearing) {
		this.windBearing = windBearing;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public double getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(double cloudCover) {
		this.cloudCover = cloudCover;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getOzone() {
		return ozone;
	}

	public void setOzone(double ozone) {
		this.ozone = ozone;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPrecipType() {
		return precipType;
	}

	public void setPrecipType(String precipType) {
		this.precipType = precipType;
	}
	
	public double getNearestStormDistance() {
		return nearestStormDistance;
	}

	public void setNearestStormDistance(double nearestStormDistance) {
		this.nearestStormDistance = nearestStormDistance;
	}

	public double getNearestStormBearing() {
		return nearestStormBearing;
	}

	public void setNearestStormBearing(double nearestStormBearing) {
		this.nearestStormBearing = nearestStormBearing;
	}

	

	public DataDto getCurrentDto() {
		// TODO Auto-generated method stub
		return this;
	}

}
