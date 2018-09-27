package com.altimetrik.recipeExercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.recipeExercise.domain.Recipe;
import com.altimetrik.recipeExercise.external.RecipeSearchProxy;
import com.altimetrik.recipeExercise.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeSearchProxy recipeSearchProxy;
	
	@Override
	public Recipe getRecipeDetails(String query) {
		Recipe recipe = recipeSearchProxy.getRecipeDetails(query);
		return recipe;
	}

}
