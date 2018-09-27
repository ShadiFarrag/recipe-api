package com.altimetrik.recipeExercise.domain;

public class Nutrition {

	private double fat;
	
	private double protein;
	
	private double carbohydrate;

	public Nutrition() {
		super();
	}

	public Nutrition(double fat, double protein, double carbohydrate) {
		super();
		this.fat = fat;
		this.protein = protein;
		this.carbohydrate = carbohydrate;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	
	
}
