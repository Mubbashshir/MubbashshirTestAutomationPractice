package Com.bpdts.teststeps;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.BPDTS.Pages.OnlineHomeShoppingPage;
import Utils.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class  OnlineTestSteps extends TestBase {
	
	OnlineHomeShoppingPage OnlineHome=null;
	@Before
	//This method is used to initialize test drivers using initialize method of TestBase class and used to initialize PageFactory
	//currently test drivers are initialized to chrome browser
	public void setup() throws IOException {
	    initialize();
	    OnlineHome=PageFactory.initElements(driver, OnlineHomeShoppingPage.class);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}		
	
	
//Implementing the step definitions for navigating to Summer Dresses section
@Given("User is on Online Shopping and navigates to Womens Summer Dresses section")
public void user_navigate_to_Womens_Summer_Dresses_section() {
	
	driver.get(CONFIG.getProperty("testsiteName"));
	OnlineHome.navtowomensummerdresses();
    // Write code here that turns the phrase above into concrete action
    
}
 //Implementing the step definition for sorting items from low to higher prices
@And("User sort the items by SortBY price order")
public void user_sort_the_items_by_price_order()  {
   
	OnlineHome.sortitembyprices();
	    
}
 //Implementing step definitions of adding a summer dress to basket and removing it. 
@And("User adds an item to the basket and ensures its added and later removes it from the cart")
public void user_add_an_item_to_basket_and_later_decide_to_remove() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    OnlineHome.addrandomsummerdresssandremoveitfromcard();
}
 //Implementing step definition of adding second item to basket
@And("User adds a second item to the basket different from the item removed")
public void user_adds_a_second_item_to_the_basket_different_from_item_removed() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
   
	OnlineHome.navtowomensummerdresses();
	OnlineHome.sortitembyprices();
	OnlineHome.addseconditemtocartfromsummerdresses();
}
//Implementing step definition of verifying page elements after adding items.
@Then("User verfies the second item added in checkout page")
      public void use_verifies_the_second_item_added_and_navigates_to_checkout_page() {
    // Write code here that turns the phrase above into concrete actions
	//Assertions to ensure item is added to the basket
			//Assertions to ensure expected page is loaded
	   OnlineHome.verifychecksforseconditem();     
 
}


@After
// This method closes driver connections which in turn closes the browsers session used during testing. 
public void cleardown(){
    driver.quit();
	driver=null;
}


}