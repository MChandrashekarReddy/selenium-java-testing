package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dto.Elements;

public class ElementsHelper implements Elements {

	@Override
	public WebDriverWait getWait(WebDriver driver, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait;
	}

	@Override
	public WebElement getElementByName(WebDriver driver, String name) {
		try {
			WebElement element = driver.findElement(By.name(name));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getElementById(WebDriver driver, String id) {
		try {
			WebElement element = driver.findElement(By.id(id));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getElementByClassName(WebDriver driver, String className) {
		try {
			WebElement element = driver.findElement(By.className(className));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getElementByTagName(WebDriver driver, String tagName) {
		try {
			WebElement element = driver.findElement(By.tagName(tagName));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getElementByLinkText(WebDriver driver, String linkText) {
		try {
			WebElement element = driver.findElement(By.linkText(linkText));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getElementByPartialLinkText(WebDriver driver, String partialLinktext) {
		try {
			WebElement element = driver.findElement(By.partialLinkText(partialLinktext));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getElementByCssSelector(WebDriver driver, String cssSelector) {
		try {
			WebElement element = driver.findElement(By.cssSelector(cssSelector));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getElementByXPath(WebDriver driver, String xPath) {
		try {
			WebElement element = driver.findElement(By.xpath(xPath));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByName(WebDriverWait wait, String name) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementById(WebDriverWait wait, String id) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByClassName(WebDriverWait wait, String className) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByTagName(WebDriverWait wait, String tagName) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByLinkText(WebDriverWait wait, String linkText) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByPartialLinkText(WebDriverWait wait, String partialLinktext) {
		try {
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(partialLinktext)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByCssSelector(WebDriverWait wait, String cssSelector) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByXPath(WebDriverWait wait, String xPath) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementByName(WebDriverWait wait, String name) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementById(WebDriverWait wait, String id) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementByClassName(WebDriverWait wait, String className) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementByTagName(WebDriverWait wait, String tagName) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementByLinkText(WebDriverWait wait, String linkText) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementByPartialLinkText(WebDriverWait wait, String partialLinktext) {
		try {
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(partialLinktext)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementByCssSelector(WebDriverWait wait, String cssSelector) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getClickableElementByXPath(WebDriverWait wait, String xPath) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsByName(WebDriver driver, String name) {
		try {
			List<WebElement> elements = driver.findElements(By.name(name));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsById(WebDriver driver, String id) {
		try {
			List<WebElement> elements = driver.findElements(By.id(id));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsByClassName(WebDriver driver, String className) {
		try {
			List<WebElement> elements = driver.findElements(By.className(className));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsByTagName(WebDriver driver, String tagName) {
		try {
			List<WebElement> elements = driver.findElements(By.tagName(tagName));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsByLinkText(WebDriver driver, String linkText) {
		try {
			List<WebElement> elements = driver.findElements(By.linkText(linkText));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsByPartialLinkText(WebDriver driver, String partialLinktext) {
		try {
			List<WebElement> elements = driver.findElements(By.partialLinkText(partialLinktext));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsByCssSelector(WebDriver driver, String cssSelector) {
		try {
			List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getElementsByXPath(WebDriver driver, String xPath) {
		try {
			List<WebElement> elements = driver.findElements(By.xpath(xPath));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByName(WebDriverWait wait, String name) {
		try {
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(name)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsById(WebDriverWait wait, String id) {
		try {
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByClassName(WebDriverWait wait, String className) {
		try {
			List<WebElement> elements = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(className)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByTagName(WebDriverWait wait, String tagName) {
		try {
			List<WebElement> elements = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(tagName)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByLinkText(WebDriverWait wait, String linkText) {
		try {
			List<WebElement> elements = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(linkText)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByPartialLinkText(WebDriverWait wait, String partialLinktext) {
		try {
			List<WebElement> elements = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(partialLinktext)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByCssSelector(WebDriverWait wait, String cssSelector) {
		try {
			List<WebElement> elements = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByXPath(WebDriverWait wait, String xPath) {
		try {
			List<WebElement> elements = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPath)));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<WebElement> getVisibleElementsByXPathThroughElement(WebElement element, String xPath) {
		try {
			List<WebElement> elements = element.findElements(By.xpath(xPath));
			return elements;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public WebElement getVisibleElementByXPathThroughElement(WebElement element, String xPath) {
		try {
			return element.findElement(By.xpath(xPath));
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	@Override
	public void scrollTOElementSmoothly(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
	}
}
