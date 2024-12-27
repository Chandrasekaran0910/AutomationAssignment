Feature: Verify items are added to Cart on eBay
Scenario: Verify item can be added to Cart
    Given the user opens the browser
    And the user navigates to ebay.com
    And the user search for "book"
    And the user clicks on the first book in the list
    And the user switch to the item page
    And the user clicks on Add to cart
    Then the user verifies the cart has been updated and displays the number of items
