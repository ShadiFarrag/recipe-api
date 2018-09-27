package com.altimetrik.recipeExercise.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altimetrik.recipeExercise.domain.Ingredient;
import com.altimetrik.recipeExercise.service.NutritionService;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngerdientsServiceTest {
	
	@Autowired
	NutritionService nutritionService;
	
	@Test
	public void testIngerdientsCall() {
		
		Ingredient testIngerdient = nutritionService.getIngredientWithNutrition("burger");
		String foodName = "";
		
		if(testIngerdient != null) {
			foodName = testIngerdient.getFoodName();
		}
		
		assertEquals(foodName, "burger");
	
	}
}
