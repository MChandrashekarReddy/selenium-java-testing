package dto;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public interface Elements {
	
	 WebDriverWait getWait(WebDriver driver, int time);
	
	 WebElement getElementByName(WebDriver driver, String name);
	 WebElement getElementById(WebDriver driver, String id);
	 WebElement getElementByClassName(WebDriver driver, String className);
	 WebElement getElementByTagName(WebDriver driver, String tagName);
	 WebElement getElementByLinkText(WebDriver driver, String linkText);
	 WebElement getElementByPartialLinkText(WebDriver driver, String partialLinktext);
	 WebElement getElementByCssSelector(WebDriver driver, String cssSelector);
	 WebElement getElementByXPath(WebDriver driver, String xPath);
	
	 WebElement getVisibleElementByName(WebDriverWait wait, String name);
	 WebElement getVisibleElementById(WebDriverWait wait, String id);
	 WebElement getVisibleElementByClassName(WebDriverWait wait, String className);
	 WebElement getVisibleElementByTagName(WebDriverWait wait, String tagName);
	 WebElement getVisibleElementByLinkText(WebDriverWait wait, String linkText);
	 WebElement getVisibleElementByPartialLinkText(WebDriverWait wait, String partialLinktext);
	 WebElement getVisibleElementByCssSelector(WebDriverWait wait, String cssSelector);
	 WebElement getVisibleElementByXPath(WebDriverWait wait, String xPath);
	
	 WebElement getClickableElementByName(WebDriverWait wait, String name);
	 WebElement getClickableElementById(WebDriverWait wait, String id);
	 WebElement getClickableElementByClassName(WebDriverWait wait, String className);
	 WebElement getClickableElementByTagName(WebDriverWait wait, String tagName);
	 WebElement getClickableElementByLinkText(WebDriverWait wait, String linkText);
	 WebElement getClickableElementByPartialLinkText(WebDriverWait wait, String partialLinktext);
	 WebElement getClickableElementByCssSelector(WebDriverWait wait, String cssSelector);
	 WebElement getClickableElementByXPath(WebDriverWait wait, String xPath);
	 
	 WebElement getVisibleElementByXPathThroughElement(WebElement element,String xPath);
	 
	 List<WebElement> getElementsByName(WebDriver driver, String name);
	 List<WebElement> getElementsById(WebDriver driver, String id);
	 List<WebElement> getElementsByClassName(WebDriver driver, String className);
	 List<WebElement> getElementsByTagName(WebDriver driver, String tagName);
	 List<WebElement> getElementsByLinkText(WebDriver driver, String linkText);
	 List<WebElement> getElementsByPartialLinkText(WebDriver driver, String partialLinktext);
	 List<WebElement> getElementsByCssSelector(WebDriver driver, String cssSelector);
	 List<WebElement> getElementsByXPath(WebDriver driver, String xPath);
	
	 List<WebElement> getVisibleElementsByName(WebDriverWait wait, String name);
	 List<WebElement> getVisibleElementsById(WebDriverWait wait, String id);
	 List<WebElement> getVisibleElementsByClassName(WebDriverWait wait, String className);
	 List<WebElement> getVisibleElementsByTagName(WebDriverWait wait, String tagName);
	 List<WebElement> getVisibleElementsByLinkText(WebDriverWait wait, String linkText);
	 List<WebElement> getVisibleElementsByPartialLinkText(WebDriverWait wait, String partialLinktext);
	 List<WebElement> getVisibleElementsByCssSelector(WebDriverWait wait, String cssSelector);
	 List<WebElement> getVisibleElementsByXPath(WebDriverWait wait, String xPath);
	 
	 List<WebElement> getVisibleElementsByXPathThroughElement(WebElement element,String xPath);
	 
	 void scrollTOElementSmoothly(WebDriver driver,WebElement element);
	 
}
