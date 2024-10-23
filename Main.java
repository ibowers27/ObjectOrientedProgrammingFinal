package FinalProject.bowers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

import FinalProject.bowers.control.CartController;
import FinalProject.bowers.gui.CartPanel;
import FinalProject.bowers.model.Items;
import FinalProject.bowers.model.ShoppingCart;
import FinalProject.bowers.gui.ShoppingGUI;

public class Main {
    public static void main(String[] args) {
        // Create a list of products with set data
        List<Items> products = new ArrayList<>();
        products.add(new Items(1, "Shirt 1", "Flowy, cream tank top", 10.00, 5, "FinalProject/bowers/images/Shirt1Image.png"));
        products.add(new Items(2, "Shirt 2", "Drop-back, red, gingham top with bow", 15.00, 10, "FinalProject/bowers/images/Shirt2Image.png"));
        products.add(new Items(3, "Pants 1", "Flowy, brown, wide-leg pants", 20.00, 15, "FinalProject/bowers/images/Pants1Image.png"));
        products.add(new Items(4, "Skirt 1", "Flowy, floral, skirt with pink bow", 18.00, 10, "FinalProject/bowers/images/Skirt1Image.png"));
        products.add(new Items(5, "Dress 1", "Pink dress with pockets", 35.00, 10, "FinalProject/bowers/images/Dress1Image.png"));
        products.add(new Items(6, "Bag 1", "Brown shoulder bag", 28.00, 5, "FinalProject/bowers/images/Bag1Image.png"));

        // Instantiate the ShoppingCart and CartPanel
        ShoppingCart shoppingCart = new ShoppingCart();
        CartPanel cartPanel = new CartPanel();

        // Instantiate the CartController
        CartController cartController = new CartController(shoppingCart, cartPanel);

        // Create and display the ShoppingGUI
        SwingUtilities.invokeLater(() -> {
            // Pass list of items and cart controller to the GUI constructor
            ShoppingGUI shoppingGUI = new ShoppingGUI(products, cartController);
            // Display the ShoppingGUI on run
            shoppingGUI.setVisible(true);
        });
    }
}
