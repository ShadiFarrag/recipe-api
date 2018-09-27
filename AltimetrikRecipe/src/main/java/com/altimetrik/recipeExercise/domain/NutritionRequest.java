package com.altimetrik.recipeExercise.domain;

public class NutritionRequest {
	
	private String query;
	private String timezone;
	
	public NutritionRequest() {
		super();
	}

	public NutritionRequest(String query, String timezone) {
		super();
		this.query = query;
		this.timezone = timezone;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	
	
}
