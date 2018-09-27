package com.altimetrik.recipeExercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.recipeExercise.domain.Ingredient;
import com.altimetrik.recipeExercise.external.IngredientNutritionProxy;
import com.altimetrik.recipeExercise.service.NutritionService;

@Service
public class NutritionServiceImpl implements NutritionService {

	@Autowired
	IngredientNutritionProxy ingredientNutritionProxy;
	
	@Override
	public Ingredient getIngredientWithNutrition(String query) {
		Ingredient ingredient = ingredientNutritionProxy.getIngredientWithNutrition(query);
		return ingredient;
	}

}
