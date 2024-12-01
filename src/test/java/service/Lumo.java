package service;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dto.Elements;
import utility.ElementsHelper;

public class Lumo {

	WebDriver driver;
	WebDriverWait wait;
	Elements elements;
	private static String url = "https://www.demoblaze.com/";
	int totalTetsts=0;
	int passedTests=0;
	int failedTests=0;
	List<String> TestCases=new ArrayList<String>();
	List<String> passedTestCases=new ArrayList<String>();
	List<String> failedTestCases=new ArrayList<String>();

	public void launchApplication() {
		elements = new ElementsHelper();
		driver = new ChromeDriver();
		wait = elements.getWait(driver, 10);
		driver.manage().window().maximize();
		driver.get(url);
	}

	public boolean isApplicationLaunchedCorrectly() {
		WebElement title = elements.getElementByXPath(driver, "//a[@id='nava']");
		return title != null;
	}

	public void signUp(String userName,String password) throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementById(wait, "signin2").click();
		elements.getVisibleElementById(wait, "sign-username").sendKeys(userName);
		elements.getVisibleElementById(wait, "sign-password").sendKeys(password);
		elements.getClickableElementByXPath(wait, "//button[text()='Sign up']").click();
		try {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String message=alert.getText();
			alert.accept();
			if(message.equals("Sign up successful.")) {
				passedTests++;
				passedTestCases.add("Sign Up:Test Passed,User Siged up Successfully");
			}
			else {
				failedTests++;
				failedTestCases.add("Sign Up:Test Failed,Because Expected message: 'Sign up successful.' But Actutal message:'"+message+"'");
				elements.getClickableElementByXPath(wait,"//button[text()='Sign up']/preceding-sibling::*").click();
			}
		} catch (NoAlertPresentException e) {
			failedTestCases.add("Test Failed: Sign Up UnSuccessful,because 'Pop' is not displayed");
			failedTests++;
		}
	}
	public void signIn(String userName,String password) throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Log in").click();
		elements.getVisibleElementById(wait,"loginusername").sendKeys(userName);
		elements.getVisibleElementById(wait,"loginpassword").sendKeys(password);
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']").click();
		try {
			Thread.sleep(1000);
			 Alert alert = driver.switchTo().alert();
		     String message = alert.getText();
		     alert.accept();
		     failedTestCases.add("Sign In :Test Failed, Unse Unexpected Pop up");
		     failedTests++;
		} catch (NoAlertPresentException e) {
			WebElement element = elements.getClickableElementByXPath(wait, "//a[text()='Welcome Gill@gmail.com']");
			if(element!=null) {
				passedTests++;
				passedTestCases.add("Sign In:Test Passed, user Signed In");
			}
			else {
				failedTestCases.add("Sign In:Test Failed, user not signed in");
				failedTests++;
			}
		}
		
	}
	 public void addProductToCart(String product) throws InterruptedException {
		 totalTetsts++;
		 elements.getClickableElementByLinkText(wait,product).click();
		 String actualProduct = elements.getVisibleElementByXPath(wait,"//div[@id='tbodyid']/h2").getText();
		 if(product.equals(actualProduct)) {
			 elements.getClickableElementByXPath(wait,"//div[@id='tbodyid']/div[2]/div/a").click();
			 try {
					Thread.sleep(1000);
					Alert alert = driver.switchTo().alert();
					String message = alert.getText();
					alert.accept();
					if(message.equals("Product added.")) {
						elements.getClickableElementByLinkText(wait,"Cart").click();
						List<WebElement> cartProducts = elements.getVisibleElementsByXPath(wait,"//table/tbody/tr/td[2]");
						for(WebElement item :cartProducts) {
							if(item.getText().equals(product)) {
								passedTests++;
								passedTestCases.add("AddProduct:Test Passed, Porduct added to cart");
								return;
							}
						}
						failedTests++;
						failedTestCases.add("AddProduct:Test Failed, product not added to cart");
					}
					else {
						failedTests++;
						failedTestCases.add("AddProduct:Test Failed,MisMatch of message Expected:'Product added.',but Actual:'"+message+"'");
					}
				} 
			 	catch (NoAlertPresentException e) {
					failedTests++;
					failedTestCases.add("AddProduct:Test Failed,Pop Not Displayed");
				}
		 }
		 else {
			failedTests++;
			failedTestCases.add("AddProduct: Test Failed,Product missLeaded Expected:'"+product+"'Actual:'"+actualProduct+"'");
		}
		 
	 }
	
	public void placeOrderSpecifiedProduct(String product) throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Cart").click();
		List<WebElement> cartProducts = elements.getVisibleElementsByXPath(wait,"//table/tbody/tr/td[2]");
		boolean isItemExsits=false;
		for(WebElement item :cartProducts) {
			if(item.getText().equals(product)) {
				isItemExsits=true;
				break;
			}
		}
		if(isItemExsits) {
			for(WebElement item :cartProducts) {
				if(item.getText().equals(product)) {
					continue;
				}
				elements.getVisibleElementByXPathThroughElement(item,"/following-sibling::td[2]/a").click();
			}
			elements.getClickableElementByXPath(wait,"//button[text()='Place Order']").click();
			elements.getVisibleElementById(wait,"name").sendKeys("Mukku");
			elements.getVisibleElementById(wait,"country").sendKeys("India");
			elements.getVisibleElementById(wait,"city").sendKeys("Kanigiri");
			elements.getVisibleElementById(wait,"card").sendKeys("123412341234");
			elements.getVisibleElementById(wait,"month").sendKeys("Octobar");
			elements.getVisibleElementById(wait,"year").sendKeys("2024");
			elements.getClickableElementByXPath(wait,"//button[text()='Purchase']").click();
			Thread.sleep(1000);
			String message = elements.getClickableElementByXPath(wait,"//div[@class='sweet-alert  showSweetAlert visible']/h2").getText();
			if(message.equals("Thank you for your purchase!")) {
				passedTests++;
				passedTestCases.add("PlaceOrder:Test Passed,Order is placed");
			}
			else {
				failedTests++;
				failedTestCases.add("PlaceOrder:Test Failed,MissMatch of message Expected:'Thank you for your purchase!' Actual:'"+message+"'");
			}
			elements.getClickableElementByXPath(wait,"//button[text()='OK']").click();
		}
		else {
			failedTests++;
			failedTestCases.add("PlaceOrder:Test Failed,Product Not found In Cart");
		}
	}
	
	public void contact() throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Contact").click();
		elements.getVisibleElementById(wait,"recipient-email").sendKeys("mc@gmail.com");
		elements.getVisibleElementById(wait,"recipient-name").sendKeys("Mc");
		elements.getVisibleElementById(wait, "message-text").sendKeys("NA");
		elements.getClickableElementByXPath(wait,"//button[text()='Send message']").click();
		try {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			alert.accept();
			if(message.equals("Thanks for the message!!")) {
				passedTests++;
				passedTestCases.add("Contact:Test Passed,Contact Dispalyed Successfully");
			}
			else {
				failedTests++;
				failedTestCases.add("Contcat:Test Failed,Message MissMatch Expected:'Thanks for the message!!' Expected:'"+message+"'");
			}
			
		} catch (NoAlertPresentException e) {
			failedTests++;
			failedTestCases.add("Contact:Test Failed,Pop is Not displayed");
		}
	}
	public void about() {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"About us").click();
		String message = elements.getVisibleElementById(wait,"videoModalLabel").getText();
		elements.getClickableElementByXPath(wait,"//h5[@id='videoModalLabel']/../button").click();
		if(message.equals("About us")) {
			passedTests++;
			passedTestCases.add("About:Test Passed,About Displayed Properly");
		}
		else {
			failedTests++;
			failedTestCases.add("About:Test Failed,About Not Found");
		}
	}
	public void pagenation() throws InterruptedException {
		totalTetsts++;
		WebElement next = elements.getClickableElementByXPath(wait,"//button[@id='next2']");
		elements.scrollTOElementSmoothly(driver, next);
		Thread.sleep(1000);
		next.click();
		Thread.sleep(1000);
		String cssValue = next.getCssValue("display");
		if(!next.isDisplayed()) {
			WebElement prev = elements.getClickableElementByXPath(wait,"//button[@id='prev2']");
			prev.click();
			Thread.sleep(1000);
			if(prev.isEnabled()) {
				passedTests++;
				passedTestCases.add("Pagenation:Test Passed,Succesfully navigatied to OtherPage");
			}
			else {
				failedTests++;
				failedTestCases.add("Pagenation:Test Failed,Prev button is Not Enabled After Page Change");
			}
			
		}
		else {
			failedTests++;
			failedTestCases.add("Pagenation:Test Failed,Next button is Displayed After Reaching LastPage");
		}
	
	}
	public void logout() {
		totalTetsts++;
		elements.getClickableElementById(wait,"logout2").click();
		WebElement signUp = elements.getClickableElementById(wait,"signin2");
		if(signUp.isDisplayed()) {
			passedTests++;
			passedTestCases.add("Logout:Test Passed,User Loggged Out Successfully");
		}
		else {
			failedTests++;
			failedTestCases.add("Logout:Test Failed,User not Logged out Successefully");
		}
	}
	
	public void laptops() throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Laptops").click();
		Thread.sleep(1000);
		WebElement item = elements.getVisibleElementByLinkText(wait,"Sony vaio i5");
		if(item!=null) {
			passedTests++;
			passedTestCases.add("Laptops:Test Passed,Laptops are displayed after clicking laptops");
		}
		else {
			failedTests++;
			failedTestCases.add("Laptops:Test Failed,Loptops are not displayed after clicking laptops");
		}
	}
	
	public void monitors() throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Monitors").click();
		Thread.sleep(1000);
		WebElement item = elements.getVisibleElementByLinkText(wait,"Apple monitor 24");
		if(item!=null) {
			passedTests++;
			passedTestCases.add("Monitors:Test Passed,Monitors are displayed after clicking Monitors");
		}
		else {
			failedTests++;
			failedTestCases.add("Monitors:Test Failed,Monitors are not displayed after clicking Monitors");
		}
	}
	public void phones() throws InterruptedException {
		elements.getClickableElementByLinkText(wait,"Phones").click();
		Thread.sleep(1000);
		WebElement item = elements.getVisibleElementByLinkText(wait,"Samsung galaxy s6");
		if(item!=null) {
			passedTests++;
			passedTestCases.add("Phones:Test Passed,Phones are displayed after clicking Phones");
		}
		else {
			failedTests++;
			failedTestCases.add("Phones:Test Failed,Phones are not displayed after clicking Phones");
		}
	}
	public void loginWithoutCredentials() throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Log in").click();
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']").click();
		try {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			alert.accept();
			if(message.equals("Please fill out Username and Password.")) {
				passedTests++;
				passedTestCases.add("LoginWithoutCredtails:Test Passed,User not to allowed login without entering any data and Pop is displayed");
			}
			else {
				failedTests++;
				failedTestCases.add("LoginWithoutCredentails:Test Failed,User not to allowed login without entering any,But data Pop Error Message MisMatched Expected: 'Please fill out Username and Password.' Actual:'"+message+"'");
			}
		}
		catch (NoAlertPresentException e) {
			failedTests++;
			failedTestCases.add("LoginWithoutCredentails:Test Failed,Pop is Not Displayed");
		}
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']/preceding-sibling::*").click();
	}
	public void loginWithoutPassword(String userName)throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Log in").click();
		WebElement  usernameInput= elements.getVisibleElementById(wait,"loginusername");
		usernameInput.sendKeys(userName);
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']").click();
		try {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			alert.accept();
			if(message.equals("Please fill out Username and Password.")) {
				passedTests++;
				passedTestCases.add("LoginWithoutPassword:Test Passed,User not to allowed login without entering password and Pop is displayed");
				
			}
			else {
				failedTests++;
				failedTestCases.add("LoginWithoutPassword:Test Failed,User not to allowed login without entering password,But data Pop Error Message MisMatched Expected: 'Please fill out Username and Password.' Actual:'"+message+"'");
				
			}
		}
		catch (NoAlertPresentException e) {
			failedTests++;
			failedTestCases.add("LoginWithoutPassword:Test Failed,Pop is Not Displayed");
		}
		usernameInput.clear();
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']/preceding-sibling::*").click();
	}
	public void loginWithoutUserName(String password)throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Log in").click();
		WebElement passwordInput = elements.getVisibleElementById(wait,"loginpassword");
		passwordInput.sendKeys(password);
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']").click();
		try {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			alert.accept();
			if(message.equals("Please fill out Username and Password.")) {
				passedTests++;
				passedTestCases.add("LoginWithoutUserName:Test Passed,User not to allowed login without entering username and data Pop is displayed");
				
			}
			else {
				failedTests++;
				failedTestCases.add("LoginWithoutUserName:Test Failed,User not to allowed login without entering username,But data Pop Error Message MisMatched Expected: 'Please fill out Username and Password.' Actual:'"+message+"'");
				
			}
		}
		catch (NoAlertPresentException e) {
			failedTests++;
			failedTestCases.add("LoginWithoutUserName:Test Failed,Pop is Not Displayed");
		}
		passwordInput.clear();
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']/preceding-sibling::*").click();
	}
	public void loginWithInvalidCredentails(String userName,String password) throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,"Log in").click();
		WebElement  usernameInput= elements.getVisibleElementById(wait,"loginusername");
		usernameInput.sendKeys(userName);
		WebElement passwordInput = elements.getVisibleElementById(wait,"loginpassword");
		passwordInput.sendKeys(password);
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']").click();
		try {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			alert.accept();
			if(message.equals("User does not exist.")) {
				passedTests++;
				passedTestCases.add("LoginWithoutCredtails:Test Passed,User not to allowed login and data Pop is displayed");
				
			}
			else {
				failedTests++;
				failedTestCases.add("LoginWithoutCredentails:Test Failed,User not to allowed login,But data Pop Error Message MisMatched Expected: 'User does not exist.' Actual:'"+message+"'");
				
			}
			
		} catch (NoAlertPresentException e) {
			failedTests++;
			failedTestCases.add("LoginWithoutCredentails:Test Failed,Pop is Not Displayed");
		}
		usernameInput.clear();
		passwordInput.clear();
		elements.getClickableElementByXPath(wait,"//button[@onclick='logIn()']/preceding-sibling::*").click();
	}

	public void signUpWithoutCredentails() throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementById(wait, "signin2").click();
		elements.getClickableElementByXPath(wait, "//button[text()='Sign up']").click();
		try {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			alert.accept();
			if(message.equals("Please fill out Username and Password.")) {
				passedTests++;
				passedTestCases.add("SignUpWithoutCredtails:Test Passed,User not to allowed sign in without entering any data and Pop is displayed");
				
			}
			else {
				failedTests++;
				failedTestCases.add("SignUpWithoutCredtails:Test Failed,User not to allowed sign in without entering any,But data Pop Error Message MisMatched Expected: 'Please fill out Username and Password.' Actual:'"+message+"'");
				
			}
		}
		catch (NoAlertPresentException e) {
			failedTests++;
			failedTestCases.add("SignUpWithoutCredtails:Test Failed,Pop is Not Displayed");
		}
		elements.getClickableElementByXPath(wait,"//button[text()='Sign up']/preceding-sibling::*").click();
		
	}
	public void  addingProductToCartWithOutLogin(String product) throws InterruptedException {
		totalTetsts++;
		elements.getClickableElementByLinkText(wait,product).click();
		
		 String actualProduct = elements.getVisibleElementByXPath(wait,"//div[@id='tbodyid']/h2").getText();
		 if(product.equals(actualProduct)) {
			 elements.getClickableElementByXPath(wait,"//div[@id='tbodyid']/div[2]/div/a").click();
			 try {
					Thread.sleep(1000);
					Alert alert = driver.switchTo().alert();
					String message = alert.getText();
					alert.accept();
					if(message.equals("please login to add product to cart")) {
						passedTests++;
						passedTestCases.add("AddingProductToCartWithoutLogin:Test Passed, Product Not added to cart and pop up is is displayed");
					}
					else {
						failedTests++;
						failedTestCases.add("AddingProductToCartWithoutLogin:Test Failed, Product Not added to cart but Error Message MissMatch Expected:'please login to add product to cart' Actucal: '"+"'");
					}
				} 
			 	catch (NoAlertPresentException e) {
					failedTests++;
					failedTestCases.add("AddingProductToCartWithoutLogin:Test Failed,Pop is Not Displayed");
				}
		 }
		 else {
			failedTests++;
		}
	}
	public void testRun() throws InterruptedException {
		try {
			launchApplication();
			boolean isLaunched = isApplicationLaunchedCorrectly();
			if (isLaunched) {
				signUp("rinku48@gmail.com","Rinku@2001");
				Thread.sleep(500);
				signIn("Gill@gmail.com","Password@2001");
				Thread.sleep(500);
				addProductToCart("Nokia lumia 1520");
				Thread.sleep(500);
				placeOrderSpecifiedProduct("Nokia lumia 1520");
				Thread.sleep(500);
				contact();
				Thread.sleep(500);
				about();
				Thread.sleep(500);
				pagenation();
				Thread.sleep(500);
				logout();
				Thread.sleep(500);
				laptops();
				Thread.sleep(500);
				monitors();
				Thread.sleep(500);
				phones();
				Thread.sleep(500);
				loginWithoutCredentials();
				Thread.sleep(500);
				loginWithoutPassword("subhman@gmail.com");
				Thread.sleep(500);
				loginWithoutUserName("Password@2001");
				Thread.sleep(500);
				loginWithInvalidCredentails("Rohit@gmail.com","Password@2001");
				Thread.sleep(500);
				signUpWithoutCredentails();
				Thread.sleep(500);
				addingProductToCartWithOutLogin("Nokia lumia 1520");
			} else {
				System.out.println("Application did not launch correctly.");
			}
		} catch (Exception e) {
			driver.close();
			System.out.println("SomeThing Went Wrong");
		} finally {
			if (driver != null) {
				Thread.sleep(1000);
				driver.quit();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Lumo lumo = new Lumo();
		lumo.testRun();
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("TotalTets: "+lumo.totalTetsts+"\tPassed: "+lumo.passedTests+"\tFailed: "+lumo.failedTests);
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Passed Test Cases:");
		for(String testcase:lumo.passedTestCases) {
			System.out.println();
			System.out.println(testcase);
		}
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Failed Test Cases:");
		for(String testcase:lumo.failedTestCases) {
			System.out.println();
			System.out.println(testcase);
		}
	}
}
