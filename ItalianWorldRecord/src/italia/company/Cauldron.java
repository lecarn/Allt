package italia.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cauldron {

//    private List<Ingredient> ingredientList;
    private List<Ingredient> ingredientList = new ArrayList<>();
    public Cauldron() {
    }

    public void addIngredientsToCauldron() {
        Ingredient cocaCola = new Ingredient();
        cocaCola.setIngredientName("Coca Cola");
        Ingredient nutella = new Ingredient("Nutella");
        Ingredient mentos = new Ingredient("Mentos");
        Ingredient durex = new Ingredient("Durex");

        ingredientList.add(cocaCola); 
        ingredientList.add(nutella); 
        ingredientList.add(mentos); 
        ingredientList.add(durex);
    }
    public List<Ingredient> getIngredientList() { 
    	return ingredientList; 
    	}



    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public boolean isReadyForWorldRecord() {
        return (((ingredientList.get(0).getIngredientName().equals("Coca Cola")) && (ingredientList.get(1).getIngredientName().equals("Nutella")) &&
                (ingredientList.get(2).getIngredientName().equals("Mentos")) && (ingredientList.get(3).getIngredientName().equals("Durex"))) && containsValidList());
    }

    public boolean containsValidList() {
        return ((ingredientList.size() >=4) && containsValidIngredients());
    }
    public boolean containsValidIngredients() {
        for (Ingredient ingredient : ingredientList) if (!ingredient.isNotEmpty()) return false;
        return true;
    }
}
