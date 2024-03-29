// Based on the example code at http://www.seleniumhq.org/docs/03_webdriver.jsp
package edu.drexel.se320;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SeleniumTest {

    protected final String uiPath = "file:///Users/gaurangbham/Downloads/hw5/web/index.html";

    @Test
    public void testOneItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement li = driver.findElement(By.id("item1"));
            // We use startsWith because getText includes the text of the Delete button
            assertTrue("Checking correct text for added element", 
                       li.getText().startsWith("Something to do"));
        } finally {
            //driver.quit();
        }
    }

    @Test
    public void addTODOPresent() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("one");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            input.clear();
            // Make up a todo
            input.sendKeys("two");
            addButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement li1 = driver.findElement(By.id("item1"));
            // We use startsWith because getText includes the text of the Delete button
            assertTrue("Checking correct text for added element",
                    li1.getText().startsWith("one"));

            WebElement li = driver.findElement(By.id("item2"));
            // We use startsWith because getText includes the text of the Delete button
            assertTrue("Checking correct text for added element",
                    li.getText().startsWith("two"));
        } finally {
            driver.quit();
        }
    }

    @Test
    public void deleteTODOOthersPresent() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("one");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            input.clear();
            // Make up a todo
            input.sendKeys("two");
            addButton.click();

            WebElement deleteButton = driver.findElement(By.id("button1"));
            deleteButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */

            WebElement li = driver.findElement(By.id("item2"));
            // We use startsWith because getText includes the text of the Delete button
            assertTrue("Checking correct text for added element",
                    li.getText().startsWith("two"));
        } finally {
            driver.quit();
        }
    }

    @Test
    public void deleteTODOOthersPresent() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("one");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            input.clear();
            // Make up a todo
            input.sendKeys("two");
            addButton.click();

            WebElement deleteButton = driver.findElement(By.id("button1"));
            deleteButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */

            WebElement li = driver.findElement(By.id("item1"));
            // We use startsWith because getText includes the text of the Delete button
            assertTrue("Checking correct text for added element",
                    li.getText().startsWith("one"));
        } finally {
            driver.quit();
        }
    }

    }

