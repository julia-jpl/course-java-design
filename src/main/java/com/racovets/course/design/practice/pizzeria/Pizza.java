package com.racovets.course.design.practice.pizzeria;

import com.racovets.course.design.practice.pizzeria.model.Ingredients;
import com.racovets.course.design.practice.pizzeria.model.Recipe;

import java.util.Map;

public class Pizza {
    private String name;
    Recipe recipe;
    private int price;
    boolean availableForOrder;

    public Pizza (String name, Recipe recipe, int price) {
        this.name = name;
        this.recipe = recipe;
        this.price = price;
    }
    public void setAvailableForOrder (IngredientsRepository ingredientsRepo, int countOfPizzas) {
        int c = 0;
        for (Map.Entry<Ingredients, Integer> item : ingredientsRepo.ingredients.entrySet()) {
            for (Map.Entry<Ingredients, Integer> element : recipe.getRecipeMap().entrySet()) {
                if (item.getKey().equals(element.getKey())) {
                    if (item.getValue() < (element.getValue() * countOfPizzas)) {
                        c++;
                    }
                }
            }
        }
        if (c > 0) {
            availableForOrder = false;
        } else {
            availableForOrder = true;
        }
    }

    @Override
    public String toString() {
        return name + ", price " + price;
    }

    public boolean isAvailableForOrder() {
        return availableForOrder;
    }

    public int getPrice() {
        return price;
    }
}
