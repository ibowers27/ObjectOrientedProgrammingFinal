package FinalProject.bowers.gui;

import FinalProject.bowers.model.ShoppingCart;
import FinalProject.bowers.model.Items;

import javax.swing.*;
import java.awt.*;

// CartPanel inherits from JPanel from swing
public class CartPanel extends JPanel {
    // Components to display cart items: text area abd total price
    private JTextArea cartTextArea;
    private JLabel totalLabel;

    public CartPanel() {
        // Set layout and size of the cart panel
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 300)); // Set preferred size for the panel

        // Create text area to display cart items that is uneditable
        cartTextArea = new JTextArea();
        cartTextArea.setEditable(false);

        // Add scroll to the panel and center it
        JScrollPane scrollPane = new JScrollPane(cartTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create label to display total price
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(totalLabel, BorderLayout.NORTH);

        // Create a "Checkout" button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> {
            // Open an empty window for checkout
            JFrame checkoutWindow = new JFrame("Checkout");
            checkoutWindow.setSize(400, 300); // Set the size of the checkout window
            checkoutWindow.setLocationRelativeTo(null); // Center the window on the screen

            // Create a label that extracts the total in the shopping cart and show it on checkout window
            totalLabel = new JLabel("Total: " + totalLabel.getText().substring(7));
            totalLabel.setHorizontalAlignment(SwingConstants.CENTER); // Set horizontal alignment to center
            checkoutWindow.add(totalLabel, BorderLayout.NORTH); // Add the total label to the checkout window

            // Create a "Pay" button
            JButton payButton = new JButton("Pay");
            payButton.addActionListener(ev -> {
                // Close the application when "Pay" button is pressed
                System.exit(0);
            });
            // Add the "Pay" button to the bottom of the checkout window
            checkoutWindow.add(payButton, BorderLayout.SOUTH);
            checkoutWindow.setVisible(true); // Show the window
        });
        add(checkoutButton, BorderLayout.SOUTH);
    }

    // Method to update the displayed cart items
    public void updateCartItems(ShoppingCart shoppingCart) {
        StringBuilder cartContent = new StringBuilder();
        // Calculate the totalPrice here
        double totalPrice = 0;
        // For loop for adding the text of a new item and adding its price to the total
        for (Items product : shoppingCart.getItems()) {
            cartContent.append(product.getName()).append("  -  $").append(product.getPrice()).append("\n");
            totalPrice += product.getPrice();
        }
        cartTextArea.setText(cartContent.toString());
        totalLabel.setText("Total: $" + totalPrice);
    }
}
