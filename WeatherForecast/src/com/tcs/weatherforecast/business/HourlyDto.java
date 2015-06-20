package com.tcs.weatherforecast.business;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HourlyDto {

	private String summary;
	private String icon;
	private List<DataDto> listDataDto = new ArrayList<DataDto>();

	public HourlyDto(JSONObject jObj) {
		// TODO Auto-generated constructor stub
		try {
			if (jObj.has("summary"))
				this.setSummary(jObj.getString("summary"));
			else
				this.setSummary("");

			if (jObj.has("icon"))
				this.setIcon(jObj.getString("icon"));
			else
				this.setIcon("");

			for (int i = 0; i < jObj.getJSONArray("data").length(); i++) {

				JSONObject jsonObject = new JSONObject();

				jsonObject = (JSONObject) jObj.getJSONArray("data").get(i);

				DataDto dataDto = new DataDto(jsonObject);

				listDataDto.add(dataDto);
			}

			this.setListDataDto(listDataDto);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<DataDto> getListDataDto() {
		return listDataDto;
	}

	public void setListDataDto(List<DataDto> listDataDto) {
		this.listDataDto = listDataDto;
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

	public HourlyDto getHourlyDto() {
		// TODO Auto-generated method stub
		return this;
	}

}
