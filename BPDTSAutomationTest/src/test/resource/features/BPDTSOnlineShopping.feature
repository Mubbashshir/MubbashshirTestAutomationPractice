Feature: Online Shopping for Women Summer Dresses
 
  #Written by Mubbashshir Mohiuddin
  #Positive Scenarios for Automation Practice BPDTS Help
  Scenario: Online Shopping adding items to basket
   Given User is on Online Shopping and navigates to Womens Summer Dresses section
   And   User sort the items by SortBY price order
   And   User adds an item to the basket and ensures its added and later removes it from the cart
   And   User adds a second item to the basket different from the item removed
   Then  User verfies the second item added in checkout page
 