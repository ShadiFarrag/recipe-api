package com.altimetrik.recipeExercise.domain;

public class Ingredient {

	private String description;
	
	private String foodName;
	
	private double serviceQty;
	
	private String serviceUnit;
	
	private double servingUnitsGrams;
	
	private Nutrition nutrition;
	
	public Ingredient() {
		super();
	}

	
	
	
	public Ingredient(String description, String foodName, double serviceQty, String serviceUnit,
			double servingUnitsGrams, Nutrition nutrition) {
		
		super();
		this.description = description;
		this.foodName = foodName;
		this.serviceQty = serviceQty;
		this.serviceUnit = serviceUnit;
		this.servingUnitsGrams = servingUnitsGrams;
		this.nutrition = nutrition;
		
	}




	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getServiceQty() {
		return serviceQty;
	}

	public void setServiceQty(double serviceQty) {
		this.serviceQty = serviceQty;
	}

	public String getServiceUnit() {
		return serviceUnit;
	}

	public void setServiceUnit(String serviceUnit) {
		this.serviceUnit = serviceUnit;
	}

	public double getServingUnitsGrams() {
		return servingUnitsGrams;
	}

	public void setServingUnitsGrams(double servingUnitsGrams) {
		this.servingUnitsGrams = servingUnitsGrams;
	}

	public Nutrition getNutrition() {
		return nutrition;
	}

	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}
	
		
}
