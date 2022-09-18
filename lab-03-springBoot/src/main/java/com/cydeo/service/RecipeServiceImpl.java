package com.cydeo.service;

import com.cydeo.entity.Ingredients;
import com.cydeo.entity.Recipe;
import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.*;


@Component


public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;
    private final Faker faker;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
    }


    @Override
    public boolean prepareRecipe() {

        for (int i = 0; i < 20; i++) {


            Arrays.stream(RecipeType.values()).forEach(recipeType -> {
                Recipe recipe = new Recipe();
                recipe.setRecipeId(UUID.randomUUID());
                recipe.setName(faker.food().dish());
                recipe.setDuration(generateRandomValue());
                recipe.setPreparation(faker.lorem().paragraph(generateRandomValue()));
                recipe.setIngredients(prepareIngredient());
                recipe.setRecipeType(recipeType);
                recipeRepository.save(recipe);
                shareService.share(recipe);
            });
        }
        return true;


    }

    private List<Ingredients>prepareIngredient(){
        List<QuantityType>quantityTypeList=List.of(QuantityType.values());
        List<Ingredients>ingredientsList=new ArrayList<>();
        for (int i = 0; i < generateRandomValue(); i++) {


            Ingredients ingredients = new Ingredients();
            ingredients.setName(faker.food().ingredient());
            ingredients.setQuantity(generateRandomValue());
            ingredients.setQuantityType(quantityTypeList.get(new Random().nextInt(3)));

            ingredientsList.add(ingredients);
        }
        return ingredientsList;


    }

    private int generateRandomValue(){
        return new Random().nextInt(20);
    }
}




