package com.tcs.weatherforecast.view;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.tcs.weatherforecast.R;
import com.tcs.weatherforecast.business.GenericResponseDto;
import com.tcs.weatherforecast.controller.OperationalAsyncTask;
import com.tcs.weatherforecast.controller.WebserviceRequests;
import com.tcs.weatherforecast.utility.Utilities;

public class MainActivity extends ActionBarActivity implements LocationListener {

	private OperationalAsyncTask operationLoaderAsyncTask;
	Utilities utility;
	private double latitude;
	private double longitude;
	private LocationManager lMgr;
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
	private TextView txtViewHourlySummary, txtViewHourlyIcon;
	private TextView tvDailySummary, tvDailyIcon;

	private RelativeLayout rlParent;
	private TableLayout tlHeaderHourly, tlHeaderDaily;
	private TextView tvHeadingDaily;
	private TableRow tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr10, tr11,
			tr12, tr13;
	private TextView tvRo1Col1, tvRo1Col2, tvRo1Col3, tvRo1Col4;
	private TextView tvRo2Col1, tvRo2Col2, tvRo2Col3, tvRo2Col4;
	private TextView tvRo3Col1, tvRo3Col2, tvRo3Col3, tvRo3Col4;
	private TextView tvRo4Col1, tvRo4Col2, tvRo4Col3, tvRo4Col4;
	private TextView tvRo5Col1, tvRo5Col2, tvRo5Col3, tvRo5Col4;
	private TextView tvRo6Col1, tvRo6Col2, tvRo6Col3, tvRo6Col4;
	private TextView tvRo7Col1, tvRo7Col2, tvRo7Col3, tvRo7Col4;
	private TextView tvRo8Col1, tvRo8Col2, tvRo8Col3, tvRo8Col4;

	private TextView tvRo9Col1, tvRo9Col2, tvRo9Col3, tvRo9Col4;
	private TextView tvRo10Col1, tvRo10Col2, tvRo10Col3, tvRo10Col4;
	private TextView tvRo11Col1, tvRo11Col2, tvRo11Col3, tvRo11Col4;
	private TextView tvRo12Col1, tvRo12Col2, tvRo12Col3, tvRo12Col4;
	private TextView tvRo13Col1, tvRo13Col2, tvRo13Col3, tvRo13Col4;

	private TextView tvLastRow1, tvLastRow2, tvLastRow3, tvLastRow4;
	private TextView tvLastRow5, tvLastRow6, tvLastRow7, tvLastRow8;
	private TextView tvLastRow9, tvLastRow10;
	private String strLastRow;
	private HashMap<String, String> hashMap = new HashMap<String, String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		loadUI();

		if (hashMap.size() == 0) {
			hashMap.put("clear-day", "#ebfffa");
			hashMap.put("clear-night", "#000000");
			hashMap.put("rain", "#034aec");
			hashMap.put("snow", "#ffffff");
			hashMap.put("sleet", "#d9dcd3");
			hashMap.put("wind", "#1e90ff");
			hashMap.put("fog", "#f0f8ff");
			hashMap.put("cloudy", "#483d8b");
			hashMap.put("partly-cloudy-day", "#87ceeb");
			hashMap.put("partly-cloudy-night", "#000080");
			hashMap.put("hail", "#002345");
			hashMap.put("thunderstorm", "#343232");
			hashMap.put("tornado", "#637245");

		}

		lMgr = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);

		Criteria criteria = new Criteria();

		criteria.setAccuracy(Criteria.ACCURACY_FINE);

		String prefProvider = lMgr.getBestProvider(criteria, true);

		lMgr.requestLocationUpdates(prefProvider, 0, 0, this);

		updateLocation(lMgr.getLastKnownLocation(prefProvider));

		utility = new Utilities(MainActivity.this);

		callWeatherForecastService();

		findViewById(R.id.txt_tap_to_retry).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						callWeatherForecastService();
					}
				});

	}
	
	
	private void loadUI() {
		// TODO Auto-generated method stub

		rlParent = (RelativeLayout) findViewById(R.id.rl_parent);

		txtViewLatitude = (TextView) findViewById(R.id.txt_view_fetched_latitude);
		txtViewLongitude = (TextView) findViewById(R.id.txt_view_fetched_longitude);
		txtViewTimeZone = (TextView) findViewById(R.id.txt_view_fetched_timezone);
		txtViewOffset = (TextView) findViewById(R.id.txt_view_fetched_offset);
		txtViewTime = (TextView) findViewById(R.id.txt_view_fetched_time);
		txtViewSummary = (TextView) findViewById(R.id.txt_view_fetched_summary);
		txtViewIcon = (TextView) findViewById(R.id.txt_view_fetched_icon);
		txtViewPrecipIntensity = (TextView) findViewById(R.id.txt_view_fetched_precip_intensity);
		txtViewPrecipProbability = (TextView) findViewById(R.id.txt_view_fetched_precip_probability);
		txtViewPrecipType = (TextView) findViewById(R.id.txt_view_fetched_precip_type);
		txtViewTemperature = (TextView) findViewById(R.id.txt_view_fetched_temperature);
		txtViewApparentTemperature = (TextView) findViewById(R.id.txt_view_fetched_apparent_temperature);
		txtViewDewPoint = (TextView) findViewById(R.id.txt_view_fetched_dew_point);
		txtViewHumidity = (TextView) findViewById(R.id.txt_view_fetched_humidity);
		txtViewWindSpeed = (TextView) findViewById(R.id.txt_view_fetched_wind_speed);
		txtViewWindBearing = (TextView) findViewById(R.id.txt_view_wind_bearing);
		txtViewNearestStormDistance = (TextView) findViewById(R.id.txt_view_nearest_storm_distance);
		txtViewNearestStormBearing = (TextView) findViewById(R.id.txt_view_nearest_storm_bearing);
		txtViewVisibility = (TextView) findViewById(R.id.txt_view_fetched_visibility);
		txtViewCloudCover = (TextView) findViewById(R.id.txt_view_fetched_cloud_cover);
		txtViewPressure = (TextView) findViewById(R.id.txt_view_fetched_pressure);
		txtViewOzone = (TextView) findViewById(R.id.txt_view_ozone);

	
		txtViewHourlyIcon = (TextView) findViewById(R.id.txt_view_hourly_icon);
		txtViewHourlySummary = (TextView) findViewById(R.id.txt_view_hourly_summary);

		tlHeaderHourly = new TableLayout(this);
		tvHeadingDaily = new TextView(this);
		tvDailyIcon = new TextView(this);
		tvDailySummary = new TextView(this);
		tlHeaderDaily = new TableLayout(this);
		tvLastRow1 = new TextView(this);
		tvLastRow2 = new TextView(this);
		tvLastRow3 = new TextView(this);
		tvLastRow4 = new TextView(this);
		tvLastRow5 = new TextView(this);
		tvLastRow6 = new TextView(this);
		tvLastRow7 = new TextView(this);
		tvLastRow8 = new TextView(this);
		tvLastRow9 = new TextView(this);
		tvLastRow10 = new TextView(this);

		RelativeLayout.LayoutParams paramsDaily = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsTableDaily = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsDailySummary = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsDailyIcon = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsHourly = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsLastRow1 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsLastRow2 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams paramsLastRow3 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams paramsLastRow4 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams paramsLastRow5 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsLastRow6 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams paramsLastRow7 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams paramsLastRow8 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams paramsLastRow9 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		RelativeLayout.LayoutParams paramsLastRow10 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		tlHeaderHourly.setId(1);
		tvHeadingDaily.setId(2);
		tvDailySummary.setId(3);
		tvDailyIcon.setId(4);
		tlHeaderDaily.setId(5);
		tvLastRow1.setId(6);
		tvLastRow2.setId(7);
		tvLastRow3.setId(8);
		tvLastRow4.setId(9);
		tvLastRow5.setId(10);
		tvLastRow6.setId(11);
		tvLastRow7.setId(12);
		tvLastRow8.setId(13);
		tvLastRow9.setId(14);

		paramsHourly.addRule(RelativeLayout.BELOW, txtViewHourlyIcon.getId());
		paramsDaily.addRule(RelativeLayout.BELOW, 1);
		paramsDailySummary.addRule(RelativeLayout.BELOW, 2);
		paramsDailyIcon.addRule(RelativeLayout.BELOW, 3);
		paramsTableDaily.addRule(RelativeLayout.BELOW, 4);
		paramsLastRow1.addRule(RelativeLayout.BELOW, 5);
		paramsLastRow2.addRule(RelativeLayout.BELOW, 6);
		paramsLastRow3.addRule(RelativeLayout.BELOW, 7);
		paramsLastRow4.addRule(RelativeLayout.BELOW, 8);
		paramsLastRow5.addRule(RelativeLayout.BELOW, 9);
		paramsLastRow6.addRule(RelativeLayout.BELOW, 10);
		paramsLastRow7.addRule(RelativeLayout.BELOW, 11);
		paramsLastRow8.addRule(RelativeLayout.BELOW, 12);
		paramsLastRow9.addRule(RelativeLayout.BELOW, 13);
		paramsLastRow10.addRule(RelativeLayout.BELOW, 14);

		// paramsHourly.setMargins(0,
		// (int)getResources().getDimension(R.dimen.gap_between_sections), 0,
		// 0);
		// paramsDailySummary.setMargins(0,
		// (int)getResources().getDimension(R.dimen.gap_between_sections), 0,
		// 0);

		rlParent.addView(tvHeadingDaily, paramsDaily);
		rlParent.addView(tlHeaderDaily, paramsTableDaily);
		rlParent.addView(tvDailySummary, paramsDailySummary);
		rlParent.addView(tvDailyIcon, paramsDailyIcon);
		rlParent.addView(tlHeaderHourly, paramsHourly);
		rlParent.addView(tvLastRow1, paramsLastRow1);
		rlParent.addView(tvLastRow2, paramsLastRow2);
		rlParent.addView(tvLastRow3, paramsLastRow3);
		rlParent.addView(tvLastRow4, paramsLastRow4);
		rlParent.addView(tvLastRow5, paramsLastRow5);
		rlParent.addView(tvLastRow6, paramsLastRow6);
		rlParent.addView(tvLastRow7, paramsLastRow7);
		rlParent.addView(tvLastRow8, paramsLastRow8);
		rlParent.addView(tvLastRow9, paramsLastRow9);
		rlParent.addView(tvLastRow10, paramsLastRow10);

		tvHeadingDaily.setText("Daily");

		tvHeadingDaily.setBackgroundColor((int) getResources().getColor(
				R.color.black));
		tvHeadingDaily.setTextColor((int) getResources()
				.getColor(R.color.white));
	}


	private void fetchResults(GenericResponseDto genericResponseDto) {
		// TODO Auto-generated method stub

		findViewById(R.id.scroll_view).setVisibility(View.VISIBLE);

		if (genericResponseDto.getAlert().getExpires() != +0L) {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					this);

			
			alertDialogBuilder.setTitle(genericResponseDto.getAlert()
					.getTitle());

			final TextView message = new TextView(this);

			SpannableString sString = new SpannableString(genericResponseDto
					.getAlert().getDescription()
					+ " "
					+ genericResponseDto.getAlert().getUri());

			Linkify.addLinks(sString, Linkify.WEB_URLS);

			message.setText(sString);

			message.setMovementMethod(LinkMovementMethod.getInstance());

			
			alertDialogBuilder
					.setView(message)
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									
									dialog.cancel();
								}
							});
					

	
			AlertDialog alertDialog = alertDialogBuilder.create();

	
			alertDialog.show();
		}

		txtViewLatitude.setText(String.valueOf(Math.round(Double
				.valueOf(genericResponseDto.getLatitude()))));
		txtViewLongitude.setText(String.valueOf(Math.round(Double
				.valueOf(genericResponseDto.getLongitude()))));
		txtViewTimeZone.setText(genericResponseDto.getTimezone());
		txtViewOffset.setText(genericResponseDto.getOffset());

		txtViewIcon.setBackgroundColor(Color.parseColor(utility
				.iterationAndCompare(hashMap, genericResponseDto
						.getCurrentDto().getIcon())));
		txtViewIcon.setText(genericResponseDto.getCurrentDto().getIcon());
		txtViewPrecipIntensity.setText(""
				+ genericResponseDto.getCurrentDto().getPrecipIntensity()
				+ "in./hr");
		txtViewSummary.setText(genericResponseDto.getCurrentDto().getSummary());

		TableRow.LayoutParams params = new TableRow.LayoutParams(
				TableRow.LayoutParams.MATCH_PARENT,
				TableRow.LayoutParams.WRAP_CONTENT, 1f);
	

		txtViewTime.setText(utility.UnixToActual(genericResponseDto
				.getCurrentDto().getTime()));
		txtViewPrecipProbability.setText(""
				+ genericResponseDto.getCurrentDto().getPrecipProbability());
		if (genericResponseDto.getCurrentDto().getPrecipIntensity() != 0)
			txtViewPrecipType.setText(""
					+ genericResponseDto.getCurrentDto().getPrecipType());
		else
			txtViewPrecipType.setText("Not-Defined");
		txtViewTemperature.setText(""
				+ genericResponseDto.getCurrentDto().getTemperature()
				+ (char) 0x00B0 + "F");
		txtViewApparentTemperature.setText(""
				+ genericResponseDto.getCurrentDto().getApparentTemperature()
				+ (char) 0x00B0 + "F");
		txtViewDewPoint.setText(""
				+ genericResponseDto.getCurrentDto().getDewPoint()
				+ (char) 0x00B0 + "F");
		txtViewHumidity.setText(""
				+ genericResponseDto.getCurrentDto().getHumidity());
		txtViewWindSpeed.setText(""
				+ genericResponseDto.getCurrentDto().getWindSpeed() + " mi/h");

		if (genericResponseDto.getCurrentDto().getWindSpeed() != 0)
			txtViewWindBearing.setText(""
					+ genericResponseDto.getCurrentDto().getWindBearing()
					+ (char) 0x00B0);
		else
			txtViewWindBearing.setText("Not-Defined");

		txtViewVisibility.setText(""
				+ genericResponseDto.getCurrentDto().getVisibility() + " mi");
		txtViewNearestStormDistance.setText(""
				+ genericResponseDto.getCurrentDto().getNearestStormDistance()
				+ " mi");
		txtViewNearestStormBearing.setText(""
				+ genericResponseDto.getCurrentDto().getNearestStormBearing()
				+ (char) 0x00B0);
		txtViewCloudCover.setText(""
				+ genericResponseDto.getCurrentDto().getCloudCover());
		txtViewPressure.setText(""
				+ genericResponseDto.getCurrentDto().getPressure() + " mb");
		txtViewOzone.setText("" + genericResponseDto.getCurrentDto().getOzone()
				+ "DU");

		txtViewHourlyIcon.append("  "
				+ genericResponseDto.getHourlyDto().getIcon());
		txtViewHourlySummary.append("  "
				+ genericResponseDto.getHourlyDto().getSummary());

		for (int i = 0; i < genericResponseDto.getHourlyDto().getListDataDto()
				.size(); i++) {

			tr1 = new TableRow(this);
			tr1.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tr2 = new TableRow(this);
			tr2.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tr3 = new TableRow(this);
			tr3.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tr4 = new TableRow(this);
			tr4.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tr5 = new TableRow(this);
			tr5.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tr6 = new TableRow(this);
			tr6.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tr7 = new TableRow(this);
			tr7.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tr8 = new TableRow(this);
			tr8.setLayoutParams(new TableRow.LayoutParams(
					TableRow.LayoutParams.MATCH_PARENT,
					TableRow.LayoutParams.WRAP_CONTENT));

			tvRo1Col1 = new TextView(this);
			tvRo1Col2 = new TextView(this);
			tvRo1Col3 = new TextView(this);
			tvRo1Col4 = new TextView(this);
			tvRo2Col1 = new TextView(this);
			tvRo2Col2 = new TextView(this);
			tvRo2Col3 = new TextView(this);
			tvRo2Col4 = new TextView(this);
			tvRo3Col1 = new TextView(this);
			tvRo3Col2 = new TextView(this);
			tvRo3Col3 = new TextView(this);
			tvRo3Col4 = new TextView(this);
			tvRo4Col1 = new TextView(this);
			tvRo4Col2 = new TextView(this);
			tvRo4Col3 = new TextView(this);
			tvRo4Col4 = new TextView(this);
			tvRo5Col1 = new TextView(this);
			tvRo5Col2 = new TextView(this);
			tvRo5Col3 = new TextView(this);
			tvRo5Col4 = new TextView(this);
			tvRo6Col1 = new TextView(this);
			tvRo6Col2 = new TextView(this);
			tvRo6Col3 = new TextView(this);
			tvRo6Col4 = new TextView(this);
			tvRo7Col1 = new TextView(this);
			tvRo7Col2 = new TextView(this);
			tvRo7Col3 = new TextView(this);
			tvRo7Col4 = new TextView(this);
			tvRo8Col1 = new TextView(this);
			tvRo8Col2 = new TextView(this);
			tvRo8Col3 = new TextView(this);
			tvRo8Col4 = new TextView(this);

			tvRo1Col1.setLayoutParams(params);
			tvRo1Col2.setLayoutParams(params);
			tvRo1Col3.setLayoutParams(params);
			tvRo1Col4.setLayoutParams(params);
			tvRo2Col1.setLayoutParams(params);
			tvRo2Col2.setLayoutParams(params);
			tvRo2Col3.setLayoutParams(params);
			tvRo2Col4.setLayoutParams(params);
			tvRo3Col1.setLayoutParams(params);
			tvRo3Col2.setLayoutParams(params);
			tvRo3Col3.setLayoutParams(params);
			tvRo3Col4.setLayoutParams(params);
			tvRo4Col1.setLayoutParams(params);
			tvRo4Col2.setLayoutParams(params);
			tvRo4Col3.setLayoutParams(params);
			tvRo4Col4.setLayoutParams(params);
			tvRo5Col1.setLayoutParams(params);
			tvRo5Col2.setLayoutParams(params);
			tvRo5Col3.setLayoutParams(params);
			tvRo5Col4.setLayoutParams(params);
			tvRo6Col1.setLayoutParams(params);
			tvRo6Col2.setLayoutParams(params);
			tvRo6Col3.setLayoutParams(params);
			tvRo6Col4.setLayoutParams(params);
			tvRo7Col1.setLayoutParams(params);
			tvRo7Col2.setLayoutParams(params);
			tvRo7Col3.setLayoutParams(params);
			tvRo7Col4.setLayoutParams(params);
			tvRo8Col1.setLayoutParams(params);
			tvRo8Col2.setLayoutParams(params);
			tvRo8Col3.setLayoutParams(params);
			tvRo8Col4.setLayoutParams(params);

			tvRo1Col1.setText("Time");
			tvRo1Col2.setText(utility.UnixToActual(genericResponseDto
					.getHourlyDto().getListDataDto().get(i).getTime()));
			tvRo1Col3.setText("Summary");
			tvRo1Col4.setText(genericResponseDto.getHourlyDto()
					.getListDataDto().get(i).getSummary());

			tr1.addView(tvRo1Col1);
			tr1.addView(tvRo1Col2);
			tr1.addView(tvRo1Col3);
			tr1.addView(tvRo1Col4);

			
			tvRo2Col2
					.setBackgroundColor(Color.parseColor(utility
							.iterationAndCompare(hashMap, genericResponseDto
									.getHourlyDto().getListDataDto().get(i)
									.getIcon())));

			tvRo2Col1.setText("Icon");
			tvRo2Col2.setText(genericResponseDto.getHourlyDto()
					.getListDataDto().get(i).getIcon());

			tvRo2Col3.setText("Precip Intns");
			tvRo2Col4.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getPrecipIntensity() + "in./hr");

			tr2.addView(tvRo2Col1);
			tr2.addView(tvRo2Col2);
			tr2.addView(tvRo2Col3);
			tr2.addView(tvRo2Col4);

			tvRo3Col1.setText("Precip Probab");
			tvRo3Col2.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getPrecipProbability());
			tvRo3Col3.setText("Precip Type");
			if (genericResponseDto.getHourlyDto().getListDataDto().get(i)
					.getPrecipIntensity() != 0)
				tvRo3Col4.setText(genericResponseDto.getHourlyDto()
						.getListDataDto().get(i).getPrecipType());
			else
				tvRo3Col4.setText("Not-Defined");

			tr3.addView(tvRo3Col1);
			tr3.addView(tvRo3Col2);
			tr3.addView(tvRo3Col3);
			tr3.addView(tvRo3Col4);

			tvRo4Col1.setText("Temp");
			tvRo4Col2.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getTemperature() + (char) 0x00B0 + "F");
			tvRo4Col3.setText("Apparent Temp");
			tvRo4Col4.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getApparentTemperature() + (char) 0x00B0 + "F");

			tr4.addView(tvRo4Col1);
			tr4.addView(tvRo4Col2);
			tr4.addView(tvRo4Col3);
			tr4.addView(tvRo4Col4);

			tvRo5Col1.setText("Dew Point");
			tvRo5Col2.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getDewPoint() + (char) 0x00B0 + "F");
			tvRo5Col3.setText("Humidity");
			tvRo5Col4.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getHumidity());

			tr5.addView(tvRo5Col1);
			tr5.addView(tvRo5Col2);
			tr5.addView(tvRo5Col3);
			tr5.addView(tvRo5Col4);

			tvRo6Col1.setText("Wind Speed");
			tvRo6Col2.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getWindSpeed() + " mi/h");
			tvRo6Col3.setText("Wind Bearing");

			if (genericResponseDto.getHourlyDto().getListDataDto().get(i)
					.getWindSpeed() != 0)
				tvRo6Col4.setText(""
						+ genericResponseDto.getHourlyDto().getListDataDto()
								.get(i).getWindBearing() + (char) 0x00B0);
			else
				tvRo6Col4.setText("Not-Defined");

			tr6.addView(tvRo6Col1);
			tr6.addView(tvRo6Col2);
			tr6.addView(tvRo6Col3);
			tr6.addView(tvRo6Col4);

			tvRo7Col1.setText("Visibility");
			tvRo7Col2.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getVisibility() + " mi");
			tvRo7Col3.setText("Cloud Cover");
			tvRo7Col4.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getCloudCover());

			tr7.addView(tvRo7Col1);
			tr7.addView(tvRo7Col2);
			tr7.addView(tvRo7Col3);
			tr7.addView(tvRo7Col4);

			tvRo8Col1.setText("Pressure");
			tvRo8Col2.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getPressure() + " mb");
			tvRo8Col3.setText("Ozone");
			tvRo8Col4.setText(""
					+ genericResponseDto.getHourlyDto().getListDataDto().get(i)
							.getOzone() + " DU");

			tr8.addView(tvRo8Col1);
			tr8.addView(tvRo8Col2);
			tr8.addView(tvRo8Col3);
			tr8.addView(tvRo8Col4);

			tlHeaderHourly.addView(tr1);
			tlHeaderHourly.addView(tr2);
			tlHeaderHourly.addView(tr3);
			tlHeaderHourly.addView(tr4);
			tlHeaderHourly.addView(tr5);
			tlHeaderHourly.addView(tr6);
			tlHeaderHourly.addView(tr7);
			tlHeaderHourly.addView(tr8);

		}

		tvDailySummary.setText("Summary:  "
				+ genericResponseDto.getDailyDto().getSummary());
		tvDailyIcon.setText("Icon:  "
				+ genericResponseDto.getDailyDto().getIcon());

		for (int i = 0; i < genericResponseDto.getDailyDto().getListDataDto()
				.size(); i++) {

			tr1 = new TableRow(this);
			tr1.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr2 = new TableRow(this);
			tr2.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr3 = new TableRow(this);
			tr3.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr4 = new TableRow(this);
			tr4.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr5 = new TableRow(this);
			tr5.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr6 = new TableRow(this);
			tr6.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr7 = new TableRow(this);
			tr7.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr8 = new TableRow(this);
			tr8.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr9 = new TableRow(this);
			tr9.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr10 = new TableRow(this);
			tr10.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr11 = new TableRow(this);
			tr11.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr12 = new TableRow(this);
			tr12.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tr13 = new TableRow(this);
			tr13.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));

			tvRo1Col1 = new TextView(this);
			tvRo1Col2 = new TextView(this);
			tvRo1Col3 = new TextView(this);
			tvRo1Col4 = new TextView(this);
			tvRo2Col1 = new TextView(this);
			tvRo2Col2 = new TextView(this);
			tvRo2Col3 = new TextView(this);
			tvRo2Col4 = new TextView(this);
			tvRo3Col1 = new TextView(this);
			tvRo3Col2 = new TextView(this);
			tvRo3Col3 = new TextView(this);
			tvRo3Col4 = new TextView(this);
			tvRo4Col1 = new TextView(this);
			tvRo4Col2 = new TextView(this);
			tvRo4Col3 = new TextView(this);
			tvRo4Col4 = new TextView(this);
			tvRo5Col1 = new TextView(this);
			tvRo5Col2 = new TextView(this);
			tvRo5Col3 = new TextView(this);
			tvRo5Col4 = new TextView(this);
			tvRo6Col1 = new TextView(this);
			tvRo6Col2 = new TextView(this);
			tvRo6Col3 = new TextView(this);
			tvRo6Col4 = new TextView(this);
			tvRo7Col1 = new TextView(this);
			tvRo7Col2 = new TextView(this);
			tvRo7Col3 = new TextView(this);
			tvRo7Col4 = new TextView(this);
			tvRo8Col1 = new TextView(this);
			tvRo8Col2 = new TextView(this);
			tvRo8Col3 = new TextView(this);
			tvRo8Col4 = new TextView(this);
			tvRo9Col1 = new TextView(this);
			tvRo9Col2 = new TextView(this);
			tvRo9Col3 = new TextView(this);
			tvRo9Col4 = new TextView(this);
			tvRo10Col1 = new TextView(this);
			tvRo10Col2 = new TextView(this);
			tvRo10Col3 = new TextView(this);
			tvRo10Col4 = new TextView(this);
			tvRo11Col1 = new TextView(this);
			tvRo11Col2 = new TextView(this);
			tvRo11Col3 = new TextView(this);
			tvRo11Col4 = new TextView(this);
			tvRo12Col1 = new TextView(this);
			tvRo12Col2 = new TextView(this);
			tvRo12Col3 = new TextView(this);
			tvRo12Col4 = new TextView(this);
			tvRo13Col1 = new TextView(this);
			tvRo13Col2 = new TextView(this);
			tvRo13Col3 = new TextView(this);
			tvRo13Col4 = new TextView(this);

			tvRo1Col1.setLayoutParams(params);
			tvRo1Col2.setLayoutParams(params);
			tvRo1Col3.setLayoutParams(params);
			tvRo1Col4.setLayoutParams(params);
			tvRo2Col1.setLayoutParams(params);
			tvRo2Col2.setLayoutParams(params);
			tvRo2Col3.setLayoutParams(params);
			tvRo2Col4.setLayoutParams(params);
			tvRo3Col1.setLayoutParams(params);
			tvRo3Col2.setLayoutParams(params);
			tvRo3Col3.setLayoutParams(params);
			tvRo3Col4.setLayoutParams(params);
			tvRo4Col1.setLayoutParams(params);
			tvRo4Col2.setLayoutParams(params);
			tvRo4Col3.setLayoutParams(params);
			tvRo4Col4.setLayoutParams(params);
			tvRo5Col1.setLayoutParams(params);
			tvRo5Col2.setLayoutParams(params);
			tvRo5Col3.setLayoutParams(params);
			tvRo5Col4.setLayoutParams(params);
			tvRo6Col1.setLayoutParams(params);
			tvRo6Col2.setLayoutParams(params);
			tvRo6Col3.setLayoutParams(params);
			tvRo6Col4.setLayoutParams(params);
			tvRo7Col1.setLayoutParams(params);
			tvRo7Col2.setLayoutParams(params);
			tvRo7Col3.setLayoutParams(params);
			tvRo7Col4.setLayoutParams(params);
			tvRo8Col1.setLayoutParams(params);
			tvRo8Col2.setLayoutParams(params);
			tvRo8Col3.setLayoutParams(params);
			tvRo8Col4.setLayoutParams(params);
			tvRo9Col1.setLayoutParams(params);
			tvRo9Col2.setLayoutParams(params);
			tvRo9Col3.setLayoutParams(params);
			tvRo9Col4.setLayoutParams(params);
			tvRo10Col1.setLayoutParams(params);
			tvRo10Col2.setLayoutParams(params);
			tvRo10Col3.setLayoutParams(params);
			tvRo10Col4.setLayoutParams(params);
			tvRo11Col1.setLayoutParams(params);
			tvRo11Col2.setLayoutParams(params);
			tvRo11Col3.setLayoutParams(params);
			tvRo11Col4.setLayoutParams(params);
			tvRo12Col1.setLayoutParams(params);
			tvRo12Col2.setLayoutParams(params);
			tvRo12Col3.setLayoutParams(params);
			tvRo12Col4.setLayoutParams(params);
			tvRo13Col1.setLayoutParams(params);
			tvRo13Col2.setLayoutParams(params);
			tvRo13Col3.setLayoutParams(params);
			tvRo13Col4.setLayoutParams(params);

			tvRo1Col1.setText("Time");
			tvRo1Col2.setText(utility.UnixToActual(genericResponseDto
					.getDailyDto().getListDataDto().get(i).getTime()));
			tvRo1Col3.setText("Summary");
			tvRo1Col4.setText("");
			// + genericResponseDto.getDailyDto().getListDataDto().get(i)
			// .getSummary());

			tr1.addView(tvRo1Col1);
			tr1.addView(tvRo1Col2);
			tr1.addView(tvRo1Col3);
			tr1.addView(tvRo1Col4);

			tvRo2Col1.setText("Icon");
			tvRo2Col2.setText(genericResponseDto.getDailyDto().getListDataDto()
					.get(i).getIcon());

			
			tvRo2Col2.setBackgroundColor(Color.parseColor(utility
					.iterationAndCompare(hashMap, genericResponseDto
							.getDailyDto().getListDataDto().get(i).getIcon())));

			tvRo2Col3.setText("Sunrise Time");
			tvRo2Col4.setText(""
					+ utility.UnixToActual(genericResponseDto.getDailyDto()
							.getListDataDto().get(i).getSunriseTime()));

			tr2.addView(tvRo2Col1);
			tr2.addView(tvRo2Col2);
			tr2.addView(tvRo2Col3);
			tr2.addView(tvRo2Col4);

			tvRo3Col1.setText("Sunset Time");
			tvRo3Col2.setText(""
					+ utility.UnixToActual(genericResponseDto.getDailyDto()
							.getListDataDto().get(i).getSunsetTime()));
			tvRo3Col3.setText("Moon Phase");
			tvRo3Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getMoonPhase());
			tr3.addView(tvRo3Col1);
			tr3.addView(tvRo3Col2);
			tr3.addView(tvRo3Col3);
			tr3.addView(tvRo3Col4);

			tvRo4Col1.setText("Precip In");
			tvRo4Col2.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getPrecipIntensity() + "in./hr");
			tvRo4Col3.setText("Precip In Max");
			tvRo4Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getPrecipIntensityMax());

			tr4.addView(tvRo4Col1);
			tr4.addView(tvRo4Col2);
			tr4.addView(tvRo4Col3);
			tr4.addView(tvRo4Col4);

			tvRo5Col1.setText("Precip In Mx Tm");
			tvRo5Col2.setText(""
					+ utility.UnixToActual(genericResponseDto.getDailyDto()
							.getListDataDto().get(i)
							.getPrecipIntensityMaxTime()));
			tvRo5Col3.setText("Precip Probab");
			tvRo5Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getPrecipProbability());

			tr5.addView(tvRo5Col1);
			tr5.addView(tvRo5Col2);
			tr5.addView(tvRo5Col3);
			tr5.addView(tvRo5Col4);

			tvRo6Col1.setText("Precip Type");

			if (genericResponseDto.getDailyDto().getListDataDto().get(i)
					.getPrecipIntensity() != 0)
				tvRo6Col2.setText(""
						+ genericResponseDto.getDailyDto().getListDataDto()
								.get(i).getPrecipType());
			else
				tvRo6Col2.setText("Not-Defined");

			tvRo6Col3.setText("Temp Min");
			tvRo6Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getTemperatureMin() + (char) 0x00B0 + "F");

			tr6.addView(tvRo6Col1);
			tr6.addView(tvRo6Col2);
			tr6.addView(tvRo6Col3);
			tr6.addView(tvRo6Col4);

			tvRo7Col1.setText("Temp Min Time");
			tvRo7Col2.setText(""
					+ utility.UnixToActual(genericResponseDto.getDailyDto()
							.getListDataDto().get(i).getTemperatureMinTime()));
			tvRo7Col3.setText("Temp Max");
			tvRo7Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getTemperatureMax() + (char) 0x00B0 + "F");

			tr7.addView(tvRo7Col1);
			tr7.addView(tvRo7Col2);
			tr7.addView(tvRo7Col3);
			tr7.addView(tvRo7Col4);

			tvRo8Col1.setText("Temp Max Tme");
			tvRo8Col2.setText(""
					+ utility.UnixToActual(genericResponseDto.getDailyDto()
							.getListDataDto().get(i).getTemperatureMaxTime()));
			tvRo8Col3.setText("App Temp Min");
			tvRo8Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getApparentTemperatureMin() + (char) 0x00B0 + "F");

			tr8.addView(tvRo8Col1);
			tr8.addView(tvRo8Col2);
			tr8.addView(tvRo8Col3);
			tr8.addView(tvRo8Col4);

			tvRo9Col1.setText("App Temp Min Time");
			tvRo9Col2.setText(utility.UnixToActual(genericResponseDto
					.getDailyDto().getListDataDto().get(i)
					.getApparentTemperatureMinTime()));
			tvRo9Col3.setText("App Temp Max");
			tvRo9Col4.setText(genericResponseDto.getDailyDto().getListDataDto()
					.get(i).getApparentTemperatureMax()
					+ (char) 0x00B0 + "F");

			tr9.addView(tvRo9Col1);
			tr9.addView(tvRo9Col2);
			tr9.addView(tvRo9Col3);
			tr9.addView(tvRo9Col4);

			tvRo10Col1.setText("App Temp Max Time");
			tvRo10Col2.setText(utility.UnixToActual(genericResponseDto
					.getDailyDto().getListDataDto().get(i)
					.getApparentTemperatureMaxTime()));

			tvRo10Col3.setText("Dew Point");
			tvRo10Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getDewPoint() + (char) 0x00B0 + "F");

			tr10.addView(tvRo10Col1);
			tr10.addView(tvRo10Col2);
			tr10.addView(tvRo10Col3);
			tr10.addView(tvRo10Col4);

			tvRo11Col1.setText("Humidity");
			tvRo11Col2.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getHumidity());
			tvRo11Col3.setText("Wind Speed");

			tvRo11Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getWindSpeed() + " mi/h");

			tr11.addView(tvRo11Col1);
			tr11.addView(tvRo11Col2);
			tr11.addView(tvRo11Col3);
			tr11.addView(tvRo11Col4);

			tvRo12Col1.setText("Wind Bearing");

			if (genericResponseDto.getDailyDto().getListDataDto().get(i)
					.getWindSpeed() != 0)
				tvRo12Col2.setText(""
						+ genericResponseDto.getDailyDto().getListDataDto()
								.get(i).getWindSpeed() + (char) 0x00B0);
			else
				tvRo12Col2.setText("Not-Defined");

			tvRo12Col3.setText("Cloud Cover");
			tvRo12Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getCloudCover());

			tr12.addView(tvRo12Col1);
			tr12.addView(tvRo12Col2);
			tr12.addView(tvRo12Col3);
			tr12.addView(tvRo12Col4);

			tvRo13Col3.setText("Pressure");
			tvRo13Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getPressure() + " mb");
			tvRo13Col3.setText("Ozone");
			tvRo13Col4.setText(""
					+ genericResponseDto.getDailyDto().getListDataDto().get(i)
							.getOzone());

			tr13.addView(tvRo13Col1);
			tr13.addView(tvRo13Col2);
			tr13.addView(tvRo13Col3);
			tr13.addView(tvRo13Col4);

			tlHeaderDaily.addView(tr1);
			tlHeaderDaily.addView(tr2);
			tlHeaderDaily.addView(tr3);
			tlHeaderDaily.addView(tr4);
			tlHeaderDaily.addView(tr5);
			tlHeaderDaily.addView(tr6);
			tlHeaderDaily.addView(tr7);
			tlHeaderDaily.addView(tr8);
			tlHeaderDaily.addView(tr9);
			tlHeaderDaily.addView(tr10);
			tlHeaderDaily.addView(tr11);
			tlHeaderDaily.addView(tr12);
			tlHeaderDaily.addView(tr13);

		}

		String strLastRow = "Sources";

		for (int i = 0; i < genericResponseDto.getFlags().getSources().length; i++) {
			Log.d("flags sources " + (i + 1), genericResponseDto.getFlags()
					.getSources()[i]);
			if (i == 0)
				strLastRow = strLastRow.concat(": "
						+ genericResponseDto.getFlags().getSources()[i]);
			else
				strLastRow = strLastRow.concat(", "
						+ genericResponseDto.getFlags().getSources()[i]);
		}

		tvLastRow1.setText(strLastRow);

		strLastRow = "";

		strLastRow = "isd-stations";

		if (genericResponseDto.getFlags().getIsdstation().length != 0) {
			for (int i = 0; i < genericResponseDto.getFlags().getIsdstation().length; i++) {

				if (i == 0)
					strLastRow = strLastRow.concat(": "
							+ genericResponseDto.getFlags().getIsdstation()[i]);
				else
					strLastRow = strLastRow.concat(", "
							+ genericResponseDto.getFlags().getIsdstation()[i]);

				Log.d("flags isd-stations " + (i + 1), genericResponseDto
						.getFlags().getIsdstation()[i]);

				tvLastRow2.setVisibility(View.VISIBLE);
				tvLastRow2.setText(strLastRow);
			}
		} else {
			tvLastRow2.setText(strLastRow);
			tvLastRow2.setVisibility(View.GONE);

		}

		strLastRow = "";

		strLastRow = "madi-stations";

		if (genericResponseDto.getFlags().getMadisstations().length != 0) {
			for (int i = 0; i < genericResponseDto.getFlags()
					.getMadisstations().length; i++) {

				if (i == 0)
					strLastRow = strLastRow
							.concat(": "
									+ genericResponseDto.getFlags()
											.getMadisstations()[i]);
				else
					strLastRow = strLastRow
							.concat(", "
									+ genericResponseDto.getFlags()
											.getMadisstations()[i]);

				Log.d("flags madi-stations " + (i + 1), genericResponseDto
						.getFlags().getMadisstations()[i]);
				tvLastRow3.setText(strLastRow);
				tvLastRow3.setVisibility(View.VISIBLE);
			}
		} else {
			tvLastRow3.setText(strLastRow);
			tvLastRow3.setVisibility(View.GONE);
		}

		Log.d("flags units", genericResponseDto.getFlags().getUnits());

		tvLastRow4.setText("Units " + genericResponseDto.getFlags().getUnits());

		strLastRow = "";

		strLastRow = "darksky-unavailable";

		for (int i = 0; i < genericResponseDto.getFlags()
				.getDarkskyunavailable().length; i++) {

			if (i == 0)
				strLastRow = strLastRow
						.concat(": "
								+ genericResponseDto.getFlags()
										.getDarkskyunavailable()[i]);
			else
				strLastRow = strLastRow
						.concat(", "
								+ genericResponseDto.getFlags()
										.getDarkskyunavailable()[i]);

		}

		strLastRow = "";

		strLastRow = "darksky-stations";

		for (int i = 0; i < genericResponseDto.getFlags().getDarkskystations().length; i++) {

			if (i == 0)
				strLastRow = strLastRow
						.concat(": "
								+ genericResponseDto.getFlags()
										.getDarkskystations()[i]);
			else
				strLastRow = strLastRow
						.concat(", "
								+ genericResponseDto.getFlags()
										.getDarkskystations()[i]);

		}

		strLastRow = "";

		strLastRow = "datapoint-stations";

		for (int i = 0; i < genericResponseDto.getFlags()
				.getDatapointstations().length; i++) {

			if (i == 0)
				strLastRow = strLastRow
						.concat(": "
								+ genericResponseDto.getFlags()
										.getDatapointstations()[i]);
			else
				strLastRow = strLastRow
						.concat(", "
								+ genericResponseDto.getFlags()
										.getDatapointstations()[i]);

		}

		strLastRow = "";

		strLastRow = "lamp-stations";

		for (int i = 0; i < genericResponseDto.getFlags().getLampstations().length; i++) {

			if (i == 0)
				strLastRow = strLastRow.concat(": "
						+ genericResponseDto.getFlags().getLampstations()[i]);
			else
				strLastRow = strLastRow.concat(", "
						+ genericResponseDto.getFlags().getLampstations()[i]);

		}

		strLastRow = "";

		strLastRow = "metar-stations";

		for (int i = 0; i < genericResponseDto.getFlags().getMetarstations().length; i++) {

			if (i == 0)
				strLastRow = strLastRow.concat(": "
						+ genericResponseDto.getFlags().getMetarstations()[i]);
			else
				strLastRow = strLastRow.concat(", "
						+ genericResponseDto.getFlags().getMetarstations()[i]);

		}

		strLastRow = "";

		strLastRow = "metno-license";

		for (int i = 0; i < genericResponseDto.getFlags().getMetnolicense().length; i++) {

			if (i == 0)
				strLastRow = strLastRow.concat(": "
						+ genericResponseDto.getFlags().getMetnolicense()[i]);
			else
				strLastRow = strLastRow.concat(", "
						+ genericResponseDto.getFlags().getMetnolicense()[i]);

		}

	}

	
	private void updateLocation(Location lastKnownLocation) {
		// TODO Auto-generated method stub
		if (lastKnownLocation == null)
			return;

		latitude = (float) lastKnownLocation.getLatitude();
		longitude = (float) lastKnownLocation.getLongitude();
	}

	/**
	 * This function is used to call the bill void service
	 */
	public void callWeatherForecastService() {

		operationLoaderAsyncTask = new OperationalAsyncTask(MainActivity.this) {

			@Override
			public void preOperation() {

			}

			@Override
			public void postOperation(String result) {

				try {
					if (!result.equalsIgnoreCase(getResources().getString(
							R.string.weather_update_not_fetched_lat_long)
							.toString())
							&& !result.equals(null)) {

						try {

							JSONObject jObj = new JSONObject(result);

							GenericResponseDto genericResponseDto = new GenericResponseDto(
									jObj);

							fetchResults(genericResponseDto);

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(
									getApplicationContext(),
									getResources()
											.getString(
													R.string.weather_update_not_fetched_server_not_responding)
											.toString(), Toast.LENGTH_SHORT)
									.show();
							findViewById(R.id.scroll_view).setVisibility(View.GONE);
							findViewById(R.id.txt_tap_to_retry).setVisibility(View.VISIBLE);
						}

					} else {

						if (result.equalsIgnoreCase(getResources().getString(
								R.string.weather_update_not_fetched_lat_long)
								.toString())) {
							Toast.makeText(
									getApplicationContext(),
									getResources()
											.getString(
													R.string.weather_update_not_fetched_lat_long)
											.toString(), Toast.LENGTH_SHORT)
									.show();
							findViewById(R.id.scroll_view).setVisibility(View.GONE);
							findViewById(R.id.txt_tap_to_retry).setVisibility(View.VISIBLE);
						} else {
							Toast.makeText(
									getApplicationContext(),
									getResources()
											.getString(
													R.string.weather_update_not_fetched_server_not_responding)
											.toString(), Toast.LENGTH_SHORT)
									.show();
							findViewById(R.id.scroll_view).setVisibility(View.GONE);
							findViewById(R.id.txt_tap_to_retry).setVisibility(View.VISIBLE);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception

					e.printStackTrace();

					Toast.makeText(
							getApplicationContext(),
							getResources()
									.getString(
											R.string.weather_update_not_fetched_server_not_responding)
									.toString(), Toast.LENGTH_SHORT).show();
					findViewById(R.id.scroll_view).setVisibility(View.GONE);
					findViewById(R.id.txt_tap_to_retry).setVisibility(View.VISIBLE);
				}

			}

			@Override
			public String performOperation() {

				String result = null;

				if (!String.valueOf(latitude).equals(null)
						&& !String.valueOf(longitude).equals(null)) {
					result = new WebserviceRequests(MainActivity.this)
							.getWeatherForecastData(String.valueOf(latitude),
									String.valueOf(longitude));
					// result = new WebserviceRequests(MainActivity.this)
					// .getWeatherForecastData("33", "151");

				} else {
					result = getResources().getString(
							R.string.weather_update_not_fetched_lat_long)
							.toString();
				}

				return result;
			}

		};

		ExecuteAsyncTask();

	}

	private void ExecuteAsyncTask() {
		// TODO Auto-generated method stub
		if (utility.isNetworkOnline()) {
			operationLoaderAsyncTask.execute();

			findViewById(R.id.txt_tap_to_retry).setVisibility(View.GONE);
		} else {
			findViewById(R.id.scroll_view).setVisibility(View.GONE);
			findViewById(R.id.txt_tap_to_retry).setVisibility(View.VISIBLE);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		lMgr.removeUpdates(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_refresh) {
			callWeatherForecastService();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if (location != null) {
			latitude = location.getLatitude();
			longitude = location.getLongitude();
		} else {
			Toast.makeText(getApplicationContext(),
					getResources().getString(R.string.lat_long_not_fetched),
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}
