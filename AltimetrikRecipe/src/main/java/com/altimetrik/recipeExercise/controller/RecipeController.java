package com.altimetrik.recipeExercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.recipeExercise.domain.Ingredient;
import com.altimetrik.recipeExercise.domain.Recipe;
import com.altimetrik.recipeExercise.external.IngredientNutritionProxy;
import com.altimetrik.recipeExercise.service.NutritionService;
import com.altimetrik.recipeExercise.service.RecipeService;


@RestController
@RequestMapping("/altimetrik")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	NutritionService nutritionService;

	@GetMapping("/recipe-api/{food}")
	public ResponseEntity<?> getRecipe(@PathVariable String food) {
		Recipe recipe = recipeService.getRecipeDetails(food);
		return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
	}
	
	@GetMapping("/ingredient-details/{search}")
	public ResponseEntity<?> getIngredientDetails(@PathVariable String search) {
		Ingredient ingred = nutritionService.getIngredientWithNutrition(search);
		return new ResponseEntity<Ingredient>(ingred, HttpStatus.OK);
	}
	
}
