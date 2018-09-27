package com.altimetrik.recipeExercise.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.util.Iterator;

import com.altimetrik.recipeExercise.domain.Ingredient;
import com.altimetrik.recipeExercise.domain.Recipe;
import com.altimetrik.recipeExercise.service.NutritionService;

@Component
public class RecipeSearchProxy {


	@Autowired
	private RestOperations restTemplate;
	
	@Autowired
	NutritionService nutritionService;
	
	public static final String RECIPE_SERVICE_URL = "https://api.edamam.com/search?app_id=c156dd75&app_key=8952084e8347cde611b2fd23e834bc4a&q=";
	
	
	public Recipe getRecipeDetails(String query) {
		
		Recipe recipe = new Recipe();
		recipe.setQuery(query);
		
		String url = RECIPE_SERVICE_URL+query;
		
		
		ResponseEntity<String> recipesResponse = this.restTemplate.getForEntity(url, String.class);
		String recipesJson = recipesResponse.getBody();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(recipesJson);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rootNode != null) {
			
			JsonNode hits = rootNode.path("hits");
			Iterator<JsonNode> elementsItr = hits.elements();
			
			if(elementsItr.hasNext()) {
				JsonNode recipeContainerElm = elementsItr.next();
				JsonNode recipeElm = recipeContainerElm.path("recipe");
				
				recipe.setName(recipeElm.path("label").asText());
				recipe.setUri(recipeElm.path("uri").asText());
				recipe.setSource(recipeElm.path("source").asText());
				
				Iterator<JsonNode> linesItr = recipeElm.path("ingredients").elements();
				while(linesItr.hasNext()) {
					
					String currentIngredient = linesItr.next().path("text").asText();
					Ingredient ingredient = nutritionService.getIngredientWithNutrition(currentIngredient); 
					recipe.addIngredient(ingredient);
					
					
				}
				
			}
			
		}
		
		recipe.calculateNutrition();
		
		return recipe;
	}
	
}
