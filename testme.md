This shopping application can be compiled on intelliJ and ran using the Main method.

This is a simple shopping simulation with a fixed number of products with clear data.
You can add things to your cart, remove them, hide/show the cart window, check the total, checkout, and "Pay."

Please test the adding and removing functions until you get errors.
    If you add too many, you will get an "out of stock" message.
    If you try to remove an item that isn't there, you get a warning.
    If you try to add without selecting an item, there is an error.
    If you try to remove without selecting an item, there is an error.

An overview of the shopping application:
I implemented the swing GUI, utilized image rendering, organized with lists and arrays, and incorporated object-oriented
programming concepts.

I divided my classes into control, gui, and model categories.
Model:
    Items - This class created the model for the items, all their attributes, and getting the rendered image icon from the file.
    ShoppingCart - This class created the model for the list of items in shopping cart, adding, removing, and quantity.
    ItemTableModel - This class created the model for the table in the GUI, column titles, and indexing.
GUI:
    ShoppingGUI - This class utilized a lot of swing to create the shopping window with its functionalities and buttons.
    ImageRenderer - This class just rendered the image for an icon in the table cell.
    CartPanel - This class also utilized swing to create a side panel for the shopping cart with its own button functions.
Control:
    CartController - This class controlled adding and removing and connected the shopping cart to the panel itself.