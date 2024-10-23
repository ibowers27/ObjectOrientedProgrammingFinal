package FinalProject.bowers.control;

import FinalProject.bowers.gui.CartPanel;
import FinalProject.bowers.model.ShoppingCart;
import FinalProject.bowers.model.Items;

import javax.swing.*;

public class CartController {
    // References
    private ShoppingCart shoppingCart;
    private CartPanel cartPanel;

    // Constructor to initialize shopping cart and cart panel
    public CartController(ShoppingCart shoppingCart, CartPanel cartPanel) {
        this.shoppingCart = shoppingCart;
        this.cartPanel = cartPanel;
    }

    // Method to set cart panel
    public void setCartPanel(CartPanel cartPanel) {
        this.cartPanel = cartPanel;
    }

    // Method to add an item to the cart, keeping track of quantities
    public void addItemToCart(Items product, int quantity) {
        // Create a variable representing the available quantity of each item
        int availableQuantity = shoppingCart.getQuantity(product);

        // Check if adding the specified quantity exceeds the available stock
        if (availableQuantity > 0) {
            // Add the item to the cart if there is enough in stock
            shoppingCart.addItem(product);

            // Update the quantity of the item in stock
            shoppingCart.updateQuantity(product, quantity);

            // Update the cart display
            cartPanel.updateCartItems(shoppingCart);
        } else {
            // Inform the user that the quantity exceeds available stock using swing warnings
            JOptionPane.showMessageDialog(null, "Only " + quantity + " units available for " + product.getName(),
                    "Insufficient Stock", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Method to remove an item from the shopping cart
    public void removeItemFromCart(Items product, int quantity) {
        // Check if the item is in the cart at all
        if (shoppingCart.getItems().contains(product)) {
            // If there is at least one, remove the item to the cart
            shoppingCart.removeItem(product);

            // Update the quantity of the item in stock
            shoppingCart.updateQuantity(product, quantity);

            // Update the cart display
            cartPanel.updateCartItems(shoppingCart);
        } else {
            // Inform the user that the cart doesn't have that item using swing warnings
            JOptionPane.showMessageDialog(null, "Already 0 units in cart for " + product.getName(),
                    "Cannot Remove Item", JOptionPane.WARNING_MESSAGE);
        }
    }
}
