package com.altimetrik.recipeExercise.service;

import com.altimetrik.recipeExercise.domain.Ingredient;

public interface NutritionService {
	public Ingredient getIngredientWithNutrition(String query);
}
