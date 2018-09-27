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
import com.altimetrik.recipeExercise.service.NutritionService;
import com.altimetrik.recipeExercise.service.RecipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/altimetrik")
@Api(value="This is Our Base Controller")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	NutritionService nutritionService;

	@ApiOperation(value = "View a recipe for some food",response = Recipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieve food recipe!"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping("/recipe-api/{food}")
	public ResponseEntity<?> getRecipe(@PathVariable String food) {
		Recipe recipe = recipeService.getRecipeDetails(food);
		return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Nutrition Details for an ingredient",response = Ingredient.class)
	@GetMapping("/ingredient-details/{search}")
	public ResponseEntity<?> getIngredientDetails(@PathVariable String search) {
		Ingredient ingred = nutritionService.getIngredientWithNutrition(search);
		return new ResponseEntity<Ingredient>(ingred, HttpStatus.OK);
	}
	
	
}
