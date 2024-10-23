package FinalProject.bowers.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // Make a list to store items in the shopping cart
    private List<Items> items;

    // Constructor that initializes the items list
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Method to add an item/product to the shopping cart
    public void addItem(Items product) {
        items.add(product);
    }

    // Method to remove an item/product from the shopping cart
    public void removeItem(Items product) {
        items.remove(product);
    }

    // Method to update the quantity of an item/product in the shopping cart
    public void updateQuantity(Items product, int newQuantity) {
        // This sets the quantity to the updated quantity
        if (items.contains(product)) {
            product.setQuantity(newQuantity);
        }
    }

    // Method to get the list of items in the shopping cart
    public List<Items> getItems() {
        return items;
    }

    // Method to get the available quantity of product
    public int getQuantity(Items product) {
        int quantityInCart = 0;
        // For loop to count how many of each item is in the cart
        for (Items item : items) {
            if (item.equals(product)) {
                quantityInCart++;
            }
        }
        // Calculate available quantity based off how much is in the cart
        int availableQuantity = product.getQuantity() - quantityInCart;
        return availableQuantity;
    }
}
