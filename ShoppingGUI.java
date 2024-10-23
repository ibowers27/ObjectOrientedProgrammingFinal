package FinalProject.bowers.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import FinalProject.bowers.control.CartController;
import FinalProject.bowers.model.ItemTableModel;
import FinalProject.bowers.model.Items;

// The gui class extends JFrame from swing
public class ShoppingGUI extends JFrame {
    // Initialize tables, buttons, and a panel
    private JTable productTable;
    private ItemTableModel tableModel;
    private JButton addToCartButton;
    private JButton removeFromCartButton;
    private CartPanel cartPanel;

    // Initialize values for the shoppingGUI in the constructor
    public ShoppingGUI(List<Items> products, CartController cartController) {
        setTitle("Product Catalog");
        // Exit/end the application when closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the default window size
        setSize(800, 600);
        // Center
        setLocationRelativeTo(null);

        // Create table model and add the item's data
        tableModel = new ItemTableModel(products);
        productTable = new JTable(tableModel);

        // Allow for single row selection
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Use the image renderer to display images in the image column
        productTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());

        // Set row height (messed around with until it looked good with the image sizes)
        productTable.setRowHeight(200);

        // Add a scroll pane and center the contents
        JScrollPane scrollPane = new JScrollPane(productTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create an "Add to Cart" button
        addToCartButton = new JButton("Add to Cart");
        // Can use "lambda" instead of new ActionListener()
        addToCartButton.addActionListener(e -> {
            // Get selected row index
            int selectedRowIndex = productTable.getSelectedRow();
            if (selectedRowIndex != -1) {
                // Get the selected product from the table model
                Items selectedProduct = tableModel.getProduct(selectedRowIndex);
                // Add the selected product to the shopping cart
                cartController.addItemToCart(selectedProduct, selectedProduct.getQuantity());
                System.out.println("Added product to cart: " + selectedProduct.getName());
            } else {
                // Add warning message if they aren't selecting an item and clicking button
                JOptionPane.showMessageDialog(ShoppingGUI.this, "Please select a product to add to cart.", "No Product Selected", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Add the "Add to Cart" button to the bottom panel
        // Had to mess around with FlowLayouts to get both buttons showing
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(addToCartButton);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        // Create ShoppingCartPanel
        cartPanel = new CartPanel();

        // Add panel to the right side of the frame
        add(cartPanel, BorderLayout.EAST);
        // Hide the panel on run
        cartPanel.setVisible(false);

        // Set cartPanel in CartController
        cartController.setCartPanel(cartPanel);

        // Create buttons to show/hide cart panel
        JButton showCartButton = new JButton("Show Cart");
        JButton hideCartButton = new JButton("Hide Cart");

        // Add action listeners to the buttons
        showCartButton.addActionListener(e -> showCartPanel());
        hideCartButton.addActionListener(e -> hideCartPanel());

        // Add buttons to the panel
        // Use GridLayout to stack using rows and columns
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(showCartButton);
        buttonPanel.add(hideCartButton);

        // Add the button panel to the main frame
        add(buttonPanel, BorderLayout.WEST); // Add panel to the west (left) side of the frame

        // Create "Remove from Cart" button
        removeFromCartButton = new JButton("Remove");
        removeFromCartButton.addActionListener(e -> {
            // Get selected row index as before
            int selectedRowIndex = productTable.getSelectedRow();
            if (selectedRowIndex != -1) {
                Items selectedProduct = tableModel.getProduct(selectedRowIndex);
                // Remove the selected product from the shopping cart
                cartController.removeItemFromCart(selectedProduct, selectedProduct.getQuantity());
                System.out.println("Removed product from cart: " + selectedProduct.getName());
            } else {
                // Add warning message if they aren't selecting an item and clicking button
                JOptionPane.showMessageDialog(ShoppingGUI.this, "Please select a product to remove from cart.", "No Product Selected", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Add the "Remove from Cart" button to the bottom panel
        JPanel bottomPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(removeFromCartButton);
        getContentPane().add(bottomPanel2, BorderLayout.NORTH);
    }

    // Methods to show and hide the shopping cart panel
    public void showCartPanel() {
        cartPanel.setVisible(true);
    }

    public void hideCartPanel() {
        cartPanel.setVisible(false);
    }
}
