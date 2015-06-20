package com.tcs.weatherforecast.business;

import org.json.JSONObject;

public class AlertDto {

	private String title;
	private long expires;
	private String description;
	private String uri;

	public AlertDto(JSONObject jsonObject) {
		// TODO Auto-generated constructor stub

		try {
			if (jsonObject.has("title"))
				this.setTitle(jsonObject.getString("title"));
			else
				this.setTitle("");
			if (jsonObject.has("expires"))
				this.setExpires(jsonObject.getLong("expires"));
			else
				this.setExpires(+0L);
			if (jsonObject.has("description"))
				this.setDescription(jsonObject.getString("description"));
			else
				this.setDescription("");
			if (jsonObject.has("uri"))
				this.setUri(jsonObject.getString("uri"));
			else
				this.setUri("");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public AlertDto getAlertDto() {
		// TODO Auto-generated method stub
		return this;
	}
}
