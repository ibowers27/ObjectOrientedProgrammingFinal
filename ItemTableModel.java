package FinalProject.bowers.model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

import FinalProject.bowers.model.Items;

// This class inherits from AbstractTableModel from swing
public class ItemTableModel extends AbstractTableModel{
    // List storing items/products
    private List<Items> products;
    // String array holding column names for the table
    private String[] columnNames = {"Image", "Name", "Description", "Price"};

    // Constructor
    public ItemTableModel(List<Items> products) {
        this.products = products;
    }

    // Override row count with the amount in table
    @Override
    public int getRowCount() {
        return products.size();
    }

    // Override column count with amount in table
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // Override the values of each item in the table and indexes
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Items product = products.get(rowIndex);
        // Switch statement to go through the rows
        switch (columnIndex) {
            case 0:
                return product.getImage(); // Return the product image
            case 1:
                return product.getName(); // REturn name
            case 2:
                return product.getDescription(); // Return description
            case 3:
                return product.getPrice(); // Return price
            case 4:
                // Return a JButton with "Add to Cart" label
                JButton addToCartButton = new JButton("Add to Cart");
                addToCartButton.addActionListener(e -> {
                    // Handle button click event
                    System.out.println("Adding product to cart: " + product.getName());
                });
                return addToCartButton;
            default:
                return null;
        }
    }

    // Override to return names of specific columns
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Method to get item/product at the specified row index
    public Items getProduct(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < products.size()) {
            // Return the row index of selected product/item
            return products.get(rowIndex);
        }
        // Otherwise return null
        return null;
    }
}
