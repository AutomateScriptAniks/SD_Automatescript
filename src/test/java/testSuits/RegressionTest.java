package testSuits;

import generics.PageActions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductListing;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utils.PropertyReader;
import static org.testng.Assert.assertTrue;

public class RegressionTest extends TestBaseClass {

    @Test
    public void verifyProductPageHappyPathUsingMultiSkuProductForNewCustomer() throws InterruptedException {
        new PageActions(driver).navigateToUrl(PropertyReader.readProperty("path.littleWood.baseUrl"));
        // Given you select a desired product from a category
        ProductListing productListPage = new HomePage(driver).chooseProduct();
        //When you select the Highest rated item and add to basket
        ProductPage productPage = productListPage.selectSpecificProduct("Highest Rated");
        productPage.checkReviews();
        //Then Credit Messaging and Multi-SKU warranty should be applicable
        productPage.selectProductOptions();
        productPage.creditMessaging();
        productPage.addTOCart();
        String subItemPriceOnProductPage = productPage.getSubItemPrice();
        String itemNumberOnProductPage = productPage.getItemNumber();
        System.out.println(itemNumberOnProductPage + "-----" + subItemPriceOnProductPage);
        ShoppingCartPage shoppingCart = productPage.confirmAddToBasket();
        String itemNumberOnCart = shoppingCart.getItemNumberInCart();
        System.out.println(itemNumberOnCart);
        String subItemPriceOnCart = shoppingCart.getSubItemPriceOnCart();
        //And Item number of selected product is the same product in the Cart
        //And the warranty is also in the Cart
        assertTrue(itemNumberOnProductPage.contains(itemNumberOnCart));
        assertTrue(subItemPriceOnCart.contains(subItemPriceOnProductPage));
    }

}
