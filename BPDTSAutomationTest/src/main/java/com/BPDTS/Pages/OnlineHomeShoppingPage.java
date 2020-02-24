
package com.BPDTS.Pages;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import Utils.TestBase;
    //This class extends TestBase call which is used to initialize and declare drivers
	public class OnlineHomeShoppingPage extends TestBase{
		
		//All Soft Assertions and Wait Class initialized
		WebDriverWait wait=new WebDriverWait(driver, 20);
		SoftAssert SoftAssertWomenpg =new SoftAssert();
		SoftAssert SoftAssertDresses =new SoftAssert();
		SoftAssert SoftAssertSummerDres= new SoftAssert();
		SoftAssert SoftAssertRandonDress=new SoftAssert();
		SoftAssert SoftAssertremoveitempageconfirmation=new SoftAssert();
		SoftAssert SoftAssertCartEmpty=new SoftAssert();
		SoftAssert SoftAssertHomePage=new SoftAssert();
		SoftAssert SoftAssertSKU=new SoftAssert();
		SoftAssert SoftAssertSummberDressesseconditem=new SoftAssert();
		SoftAssert SoftAssertCheckout1=new SoftAssert();
		SoftAssert SoftAssertSKU1=new SoftAssert();
		SoftAssert SoftAssertCheckout=new SoftAssert();
		
		
		//All the web elements declared using FindBy
		@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	    public static WebElement WomenTab;
		@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[2]/a")
        public static WebElement Dresses;
		@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")
		public static WebElement SummerDresses;
		@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
		public static WebElement RandomDresse;
		@FindBy(xpath="//button/*[text()='Add to cart']")
		public static WebElement Cartbutton;
	   	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
		public static WebElement ContinueShopping;
   		@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
   	   	public static WebElement CartSelection;
   		@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
   		public static WebElement CheckOut;
   		@FindBy(xpath="//*[@title='Delete']/i")
   		public static List<WebElement> RemoveitemfromCartbutton;
   		@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[2")
   		public static WebElement continuebacktoaddseconditem;
   		@FindBy(xpath="//*[@id='columns']/div[1]/a[4]")
   		public static WebElement backtosummberdresses;
   		@FindBy(xpath="//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img")
   		public static WebElement SummberDressesseconditem;
   		@FindBy(xpath="//*[@id='selectProductSort']")
   		public static WebElement SelectParentlowtohigh;
   	    @FindBy(xpath="//*[@id=\"selectProductSort\"]/option[2]'")
   		public static WebElement Selectchildlowtohigh;
   	    @FindBy(xpath="//*[@id='center_column']/p")
   	    public static WebElement YourCartisEmpty;
   	    @FindBy(xpath="//*[@id='columns']/div[1]/a")
   	    public static WebElement ReturnHome;
   	    @FindBy(xpath="//*[@id=\"product_5_19_0_0\"]/td[2]/small[1]")
   	    public static WebElement SKU;
   	    @FindBy(xpath="//*[@id=\"product_6_31_0_0\"]/td[2]/small[1]")
	    public static WebElement SKU1;
   	   
   	
	  //Defined method to navigate to womens summer dresses section along with checkpoints for each page using soft assertions
	   public void navtowomensummerdresses(){
			
		WomenTab.click();
	    String womenpa= driver.getCurrentUrl();
		SoftAssertWomenpg.assertEquals("http://automationpractice.com/index.php?id_category=3&controller=category", womenpa);
		Dresses.click();
		String Dress= driver.getCurrentUrl();
		SoftAssertDresses.assertEquals("http://automationpractice.com/index.php?id_category=8&controller=category", Dress);
		SummerDresses.click();
		String summer= driver.getCurrentUrl();
		SoftAssertSummerDres.assertEquals("http://automationpractice.com/index.php?id_category=11&controller=category", summer);
	
	 }
		
	//Defined method which will sort items by Lower to Higher prices.
	   public void sortitembyprices()  {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("scroll(0, 600);");
		Select objname=new Select(SelectParentlowtohigh);
        String sortorder="Price: Lowest first";
		objname.selectByVisibleText(sortorder);
        
	}   
	
	//Defined method to add and remove an Item`from cart
	   public void addrandomsummerdresssandremoveitfromcard()   {
				
		RandomDresse=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")));
		RandomDresse.click();
		String RD=driver.getCurrentUrl();
		SoftAssertRandonDress.assertEquals("http://automationpractice.com/index.php?id_product=5&controller=product", RD);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		Cartbutton.click();
		CheckOut=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")));
		CheckOut.click();
		//Assertions to ensure item is added to the basket
		String SKUStr="SKU : demo_5";
		SoftAssertSKU.assertTrue(SKUStr.contentEquals(SKU.getText()));
		String actualcheckout=driver.getCurrentUrl();		
		String checkouturl= "http://automationpractice.com/index.php?controller=order";
		SoftAssertCheckout1.assertEquals(checkouturl, actualcheckout);
		  
		//Deleting all the items in the cart
		for(int i=0;i<RemoveitemfromCartbutton.size();i++){
			RemoveitemfromCartbutton.get(i).click();
            
		}

		//Verifying checkpoints after deleting items such as Your cart is empty message etc. 		
		String confirmremoveitempage=driver.getCurrentUrl();
		String emptycartmsg="Your shopping cart is empty.";
		SoftAssertremoveitempageconfirmation.assertEquals("http://automationpractice.com/index.php?controller=order", confirmremoveitempage);
		SoftAssertCartEmpty.assertEquals(emptycartmsg, YourCartisEmpty.getText());
		ReturnHome.click();
		String actualhomepageurl=driver.getCurrentUrl();		
		String expectedhomepageurl= "http://automationpractice.com/index.php";
		SoftAssertHomePage.assertEquals(actualhomepageurl, expectedhomepageurl);
		WomenTab=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a")));
	
	}
	//adding second item to the cart
	   public void addseconditemtocartfromsummerdresses()  {
		SummberDressesseconditem.click();
		String SD=driver.getCurrentUrl();
		SoftAssertSummberDressesseconditem.assertEquals("http://automationpractice.com/index.php?id_product=6&controller=product", SD);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		Cartbutton.click();
		CheckOut=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")));
		CheckOut.click();
		}
	 //verifying the second item added to cart	
	public void verifychecksforseconditem()
	{
		SKU1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_6_31_0_0\"]/td[2]/small[1]")));
        String SKUStr1="SKU : demo_6";
		SoftAssertSKU1.assertTrue(SKUStr1.contentEquals(SKU1.getText()));
		String actualcheckout1=driver.getCurrentUrl();		
		String checkouturl1= "http://automationpractice.com/index.php?controller=order";
		SoftAssertCheckout.assertEquals(checkouturl1, actualcheckout1);
	
	}
	
	}


