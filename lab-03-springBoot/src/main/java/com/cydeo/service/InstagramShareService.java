package com.cydeo.service;

import com.cydeo.entity.Recipe;
import org.springframework.stereotype.Component;

@Component

public class InstagramShareService implements ShareService{


    @Override
    public boolean share(Recipe recipe) {

        System.out.println("Shared on facebook");
        System.out.println("RecipeType: " + recipe.getRecipeType());
        System.out.println("Recipe Name " + recipe.getName() );
        System.out.println("Ingredient List ");
        recipe.getIngredients().forEach(ingredients -> {
            System.out.println("    Ingredient Name " + ingredients.getName() + " Quantity : " + ingredients.getQuantity() +
                    " " + ingredients.getQuantityType());
        });
        System.out.println("Preperation: \n" + "\t" + recipe.getPreparation());

        return true;
    }

    }




