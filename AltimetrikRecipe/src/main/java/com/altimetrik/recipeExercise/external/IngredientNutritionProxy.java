package com.altimetrik.recipeExercise.external;

import java.io.IOException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;

import com.altimetrik.recipeExercise.domain.Ingredient;
import com.altimetrik.recipeExercise.domain.Nutrition;
import com.altimetrik.recipeExercise.domain.NutritionRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestOperations;

@Component
public class IngredientNutritionProxy {

	@Autowired
	private RestOperations restTemplate;
	public static final String NUTRITION_SERVICE_URL = "https://trackapi.nutritionix.com/v2/natural/nutrients";
	
	public Ingredient getIngredientWithNutrition(String query) {
		Ingredient ingredient = new Ingredient();
		ingredient.setDescription(query);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);

//		headers.set("Content-Type", "application/json");
		headers.set("x-app-id", "242a0de9");
		headers.set("x-app-key", "8b7a41452a0e9efe1d7fa7d55c80d727");
		headers.set("x-remote-user-id", "shadi_77");
				
//		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//		map.add("query", query);
//		map.add("timezone", "US/Eastern");

		NutritionRequest req = new NutritionRequest(query,"US/Eastern");
		HttpEntity<NutritionRequest> request = new HttpEntity<NutritionRequest>(req, headers);
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(NUTRITION_SERVICE_URL, request , String.class);
		
		String responseJson = responseEntity.getBody();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(responseJson);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rootNode != null) {
			JsonNode foods = rootNode.path("foods");
			Iterator<JsonNode> elementsItr = foods.elements();
			
			if(elementsItr.hasNext()) {
				JsonNode element = elementsItr.next();
				ingredient.setFoodName(element.path("food_name").asText());
				ingredient.setServiceQty(element.path("serving_qty").asDouble());
				ingredient.setServiceUnit(element.path("serving_unit").asText());
				ingredient.setServingUnitsGrams(element.path("serving_weight_grams").asDouble());
				ingredient.setNutrition(new Nutrition(element.path("nf_total_fat").asDouble(), element.path("nf_protein").asDouble(), element.path("nf_total_carbohydrate").asDouble()));
				
			}
			
		}
		
		return ingredient;
		
	}
	
}
