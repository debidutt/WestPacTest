package com.tcs.weatherforecast.test;

import com.tcs.weatherforecast.R;
import com.tcs.weatherforecast.view.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private Activity testMainActivity;
	private TextView txtViewLatitude, txtViewLongitude, txtViewTimeZone,
			txtViewOffset;
	private TextView txtViewTime, txtViewIcon, txtViewSummary,
			txtViewPrecipIntensity;
	private TextView txtViewPrecipProbability, txtViewPrecipType,
			txtViewTemperature, txtViewApparentTemperature;
	private TextView txtViewDewPoint, txtViewHumidity, txtViewWindSpeed,
			txtViewWindBearing;
	private TextView txtViewNearestStormDistance, txtViewNearestStormBearing;
	private TextView txtViewVisibility, txtViewCloudCover, txtViewPressure,
			txtViewOzone;
	private TextView txtViewHourlySummary, txtViewHourlyIcon, txtHeadingHourly;

	private Intent intent;

	public MainActivityTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testMainActivity = getActivity();

		txtViewLatitude = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_latitude);
		txtViewLongitude = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_longitude);
		txtViewTimeZone = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_timezone);
		txtViewOffset = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_offset);
		txtViewTime = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_time);
		txtViewSummary = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_summary);
		txtViewIcon = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_icon);
		txtViewPrecipIntensity = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_precip_intensity);
		txtViewPrecipProbability = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_precip_probability);
		txtViewPrecipType = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_precip_type);
		txtViewTemperature = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_temperature);
		txtViewApparentTemperature = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_apparent_temperature);
		txtViewDewPoint = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_dew_point);
		txtViewHumidity = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_humidity);
		txtViewWindSpeed = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_wind_speed);
		txtViewWindBearing = (TextView) testMainActivity
				.findViewById(R.id.txt_view_wind_bearing);
		txtViewNearestStormDistance = (TextView) testMainActivity
				.findViewById(R.id.txt_view_nearest_storm_distance);
		txtViewNearestStormBearing = (TextView) testMainActivity
				.findViewById(R.id.txt_view_nearest_storm_bearing);
		txtViewVisibility = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_visibility);
		txtViewCloudCover = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_cloud_cover);
		txtViewPressure = (TextView) testMainActivity
				.findViewById(R.id.txt_view_fetched_pressure);
		txtViewOzone = (TextView) testMainActivity
				.findViewById(R.id.txt_view_ozone);

		txtHeadingHourly = (TextView) testMainActivity
				.findViewById(R.id.txt_view_heading_hourly);
		txtViewHourlyIcon = (TextView) testMainActivity
				.findViewById(R.id.txt_view_hourly_icon);
		txtViewHourlySummary = (TextView) testMainActivity
				.findViewById(R.id.txt_view_hourly_summary);
	}

	public void testPreconditions() {
		assertNotNull("testMainActivity is null", testMainActivity);
		assertNotNull("txtViewLatitude is null", txtViewLatitude);
		assertNotNull("txtViewLongitude is null", txtViewLongitude);
		assertNotNull("txtViewTimeZone is null", txtViewTimeZone);
		assertNotNull("txtViewOffset is null", txtViewOffset);
		assertNotNull("txtViewTime is null", txtViewTime);
		assertNotNull("txtViewIcon is null", txtViewIcon);
		assertNotNull("txtViewPrecipIntensity is null", txtViewPrecipIntensity);
		assertNotNull("txtViewSummary is null", txtViewSummary);
		assertNotNull("txtViewPrecipProbability is null",
				txtViewPrecipProbability);
		assertNotNull("txtViewApparentTemperature is null",
				txtViewApparentTemperature);
		assertNotNull("txtViewTemperature is null", txtViewTemperature);
		assertNotNull("txtViewDewPoint is null", txtViewDewPoint);
		assertNotNull("txtViewHumidity is null", txtViewHumidity);
		assertNotNull("txtViewWindSpeed is null", txtViewWindSpeed);
		assertNotNull("txtViewWindBearing is null", txtViewWindBearing);
		assertNotNull("txtViewNearestStormDistance is null",txtViewNearestStormDistance);
		assertNotNull("txtViewNearestStormBearing is null", txtViewNearestStormBearing);
		assertNotNull("txtViewCloudCover is null", txtViewCloudCover);
		assertNotNull("txtViewPressure is null", txtViewPressure);
		assertNotNull("txtViewOzone is null", txtViewOzone);
		assertNotNull("txtHeadingHourly is null", txtHeadingHourly);
		assertNotNull("txtViewHourlyIcon is null", txtViewHourlyIcon);
		assertNotNull("txtViewHourlySummary is null", txtViewHourlySummary);

	}

}
