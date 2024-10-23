package FinalProject.bowers.model;

import javax.swing.*;
import java.net.URL;

public class Items {
    // Attributes
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private ImageIcon image;

    // Constructor that initializes values for all the parameters of an item
    public Items(int id, String name, String description, double price, int quantity, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;

        // Make an image icon for the item
        this.image = createImageIcon(imagePath);
    }

    // Getters and setters for each parameter of an item
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to retrieve the image associated with the item
    public ImageIcon getImage() {
        return image;
    }

    // This method creates an image icon that is usable for the gui with the images in the file
    // I added this because the image wasn't appearing straight from the path reference I was using in Main
    private ImageIcon createImageIcon(String imagePath) {
        // Implement a class loader to ensure picture loads in the gui
        ClassLoader classLoader = getClass().getClassLoader();
        URL imageUrl = classLoader.getResource(imagePath);
        if (imageUrl != null) {
            // Return the ImageIcon from the image URL input in main
            return new ImageIcon(imageUrl);
        } else {
            // If there is no image or it can't be found, return null
            System.out.println("Image not found: " + imagePath);
            return null;
        }
    }
}
