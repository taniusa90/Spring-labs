package com.cydeo.repository;

import com.cydeo.entity.Recipe;

public interface RecipeRepository {

    boolean save(Recipe recipe);
}
