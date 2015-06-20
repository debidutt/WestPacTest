package com.tcs.weatherforecast.business;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FlagsDto {

	private String[] sources;
	private String[] isdstation;
	private String[] madisstations;
	private String[] darkskyunavailable;
	private String[] darkskystations;
	private String[] datapointstations;
	private String[] lampstations;
	private String[] metarstations;
	private String[] metnolicense;
	private String units;

	public FlagsDto(JSONObject jsonObject) {
		// TODO Auto-generated constructor stub
		try {
		
			sources = new String[jsonObject.getJSONArray("sources").length()];
			if (jsonObject.has("isd-stations")) {
				isdstation = new String[jsonObject.getJSONArray("isd-stations")
						.length()];
			} else {
				isdstation = new String[0];
			}
			if (jsonObject.has("madis-stations")) {
				madisstations = new String[jsonObject.getJSONArray(
						"madis-stations").length()];
			} else {
				madisstations = new String[0];
			}
			if (jsonObject.has("darksky-unavailable")) {
				darkskyunavailable = new String[jsonObject.getJSONArray("darksky-unavailable")
						.length()];
			} else {
				darkskyunavailable = new String[0];
			}
			if (jsonObject.has("darksky-stations")) {
				darkskystations = new String[jsonObject.getJSONArray("darksky-stations")
						.length()];
			} else {
				darkskystations = new String[0];
			}
			if (jsonObject.has("datapoint-stations")) {
				datapointstations = new String[jsonObject.getJSONArray("datapoint-stations")
						.length()];
			} else {
				datapointstations = new String[0];
			}
			if (jsonObject.has("lamp-stations")) {
				lampstations = new String[jsonObject.getJSONArray("lamp-stations")
						.length()];
			} else {
				lampstations = new String[0];
			}
			if (jsonObject.has("metar-stations")) {
				metarstations = new String[jsonObject.getJSONArray("metar-stations")
						.length()];
			} else {
				metarstations = new String[0];
			}
			if (jsonObject.has("metno-license")) {
				metnolicense = new String[jsonObject.getJSONArray("metno-license")
						.length()];
			} else {
				metnolicense = new String[0];
			}
			
			if (jsonObject.has("sources")) {
			this.setSources(jsonObject.getJSONArray("sources"));
			}
			if (jsonObject.has("isd-stations")) {
				this.setIsdstation(jsonObject.getJSONArray("isd-stations"));
			}
			if (jsonObject.has("madis-stations")) {
				this.setMadisstations(jsonObject.getJSONArray("madis-stations"));
			}
			if (jsonObject.has("darksky-unavailable")) {
				this.setDarkskyunavailable(jsonObject.getJSONArray("darksky-unavailable"));
			}
			if (jsonObject.has("darksky-stations")) {
				this.setDarkskystations(jsonObject.getJSONArray("darksky-stations"));
			}
			if (jsonObject.has("datapoint-stations")) {
				this.setDatapointstations(jsonObject.getJSONArray("datapoint-stations"));
			}
			if (jsonObject.has("lamp-stations")) {
				this.setLampstations(jsonObject.getJSONArray("lamp-stations"));
			}
			if (jsonObject.has("metar-stations")) {
				this.setMetarstations(jsonObject.getJSONArray("metar-stations"));
			}
			if (jsonObject.has("metno-license")) {
				this.setMetarstations(jsonObject.getJSONArray("metno-license"));
			}
			if (jsonObject.has("units")) {
			this.setUnits(jsonObject.getString("units"));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getSources() {
		return this.sources;
	}

	public void setSources(JSONArray jsonArray) {

		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				this.sources[i] = jsonArray.get(i).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String[] getIsdstation() {
		return this.isdstation;
	}

	public void setIsdstation(JSONArray jsonArray) {

		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				this.isdstation[i] = jsonArray.get(i).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String[] getMadisstations() {
		return this.madisstations;
	}

	public void setMadisstations(JSONArray jsonArray) {

		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				this.madisstations[i] = jsonArray.get(i).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	 public String[] getDarkskyunavailable() {
	
	 return this.darkskyunavailable;
	 }
	
	 public void setDarkskyunavailable(JSONArray jsonArray) {
	 for (int i = 0; i < jsonArray.length(); i++) {
	 try {
	 this.darkskyunavailable[i] = jsonArray.get(i).toString();
	 } catch (JSONException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 }
	
	 public String[] getDarkskystations() {
	 return this.darkskystations;
	 }
	
	 public void setDarkskystations(JSONArray jsonArray) {
	 for (int i = 0; i < jsonArray.length(); i++) {
	 try {
	 this.darkskystations[i] = jsonArray.get(i).toString();
	 } catch (JSONException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 }
	
	 public String[] getDatapointstations() {
	 return this.datapointstations;
	 }
	
	 public void setDatapointstations(JSONArray jsonArray) {
	 for (int i = 0; i < jsonArray.length(); i++) {
	 try {
	 this.datapointstations[i] = jsonArray.get(i).toString();
	 } catch (JSONException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 }
	
	 public String[] getLampstations() {
	 return this.lampstations;
	 }
	
	 public void setLampstations(JSONArray jsonArray) {
	 for (int i = 0; i < jsonArray.length(); i++) {
	 try {
	 this.lampstations[i] = jsonArray.get(i).toString();
	 } catch (JSONException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 }
	
	 public String[] getMetarstations() {
	 return this.metarstations;
	 }
	
	 public void setMetarstations(JSONArray jsonArray) {
	 for (int i = 0; i < jsonArray.length(); i++) {
	 try {
	 this.metarstations[i] = jsonArray.get(i).toString();
	 } catch (JSONException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 }
	
	 public String[] getMetnolicense() {
	 return this.metnolicense;
	 }
	
	 public void setMetnolicense(JSONArray jsonArray) {
	 for (int i = 0; i < jsonArray.length(); i++) {
	 try {
	 this.metnolicense[i] = jsonArray.get(i).toString();
	 } catch (JSONException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 }

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public FlagsDto getFlagsDto() {
		// TODO Auto-generated method stub
		return this;
	}
}
