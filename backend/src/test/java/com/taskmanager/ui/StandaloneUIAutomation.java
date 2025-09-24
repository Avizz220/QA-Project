package com.taskmanager.ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Random;

/**
 * This is a standalone UI test runner that will visibly show the browser automating UI tasks
 * without depending on JUnit test framework which can be memory-intensive
 */
public class StandaloneUIAutomation {

    public static void main(String[] args) {
        System.out.println("🚀 Starting UI Automation Demo");
        
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        
        // Run the tests
        try {
            runUserRegistrationTest(options);
            Thread.sleep(2000); // Pause between tests
            runAddTaskTest(options);
            
            System.out.println("✅ UI Automation Demo completed successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error in UI Automation: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void runUserRegistrationTest(ChromeOptions options) throws InterruptedException {
        System.out.println("\n🔍 Running User Registration Test");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Step 1: Navigate to homepage
            System.out.println("  ▶️ Navigating to application homepage");
            driver.get("http://localhost:5173");
            Thread.sleep(1000);
            
            // Step 2: Click on Signup link
            System.out.println("  ▶️ Clicking on Signup link");
            WebElement signupLink = driver.findElement(By.linkText("Sign Up"));
            signupLink.click();
            Thread.sleep(1000);
            
            // Step 3: Generate random username to avoid duplicates
            String username = "testuser" + new Random().nextInt(10000);
            String email = username + "@example.com";
            String password = "Test@123";
            
            // Step 4: Fill the registration form
            System.out.println("  ▶️ Filling registration form with username: " + username);
            driver.findElement(By.name("username")).sendKeys(username);
            Thread.sleep(500);
            
            System.out.println("  ▶️ Entering email: " + email);
            driver.findElement(By.name("email")).sendKeys(email);
            Thread.sleep(500);
            
            System.out.println("  ▶️ Entering password");
            driver.findElement(By.name("password")).sendKeys(password);
            Thread.sleep(1000);
            
            // Step 5: Submit the form
            System.out.println("  ▶️ Submitting registration form");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(2000);
            
            // Step 6: Verify registration success (redirected to login page)
            boolean success = driver.getCurrentUrl().contains("login") || 
                              isElementPresent(driver, By.xpath("//div[contains(text(), 'registered')]"));
            
            if (success) {
                System.out.println("  ✅ User Registration Test PASSED");
            } else {
                System.out.println("  ❌ User Registration Test FAILED");
            }
            
        } finally {
            // Always close the browser
            Thread.sleep(2000); // Give time to see the final state
            driver.quit();
        }
    }
    
    private static void runAddTaskTest(ChromeOptions options) throws InterruptedException {
        System.out.println("\n🔍 Running Add Task Test");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Step 1: Navigate to homepage
            System.out.println("  ▶️ Navigating to application homepage");
            driver.get("http://localhost:5173");
            Thread.sleep(1000);
            
            // Step 2: Click on Login link
            System.out.println("  ▶️ Clicking on Login link");
            WebElement loginLink = driver.findElement(By.linkText("Login"));
            loginLink.click();
            Thread.sleep(1000);
            
            // Step 3: Login with test account
            System.out.println("  ▶️ Logging in with test account");
            driver.findElement(By.name("username")).sendKeys("testuser");
            Thread.sleep(500);
            driver.findElement(By.name("password")).sendKeys("password123");
            Thread.sleep(500);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000); // Wait for login to complete
            
            // Step 4: Check if login was successful by looking for task manager components
            if (isElementPresent(driver, By.xpath("//*[contains(text(), 'Add Task')]"))) {
                System.out.println("  ▶️ Login successful");
                
                // Step 5: Click Add Task button
                System.out.println("  ▶️ Clicking Add Task button");
                driver.findElement(By.xpath("//button[contains(text(), 'Add Task')]")).click();
                Thread.sleep(1000);
                
                // Step 6: Fill task details
                String taskTitle = "UI Automation Task " + new Random().nextInt(1000);
                System.out.println("  ▶️ Filling task details - Title: " + taskTitle);
                
                driver.findElement(By.name("title")).sendKeys(taskTitle);
                Thread.sleep(500);
                
                driver.findElement(By.name("description")).sendKeys("This task was created by Selenium automation");
                Thread.sleep(500);
                
                // Step 7: Submit the form
                System.out.println("  ▶️ Submitting the task form");
                driver.findElement(By.xpath("//button[contains(text(), 'Create')]") ).click();
                Thread.sleep(2000);
                
                // Step 8: Verify task was created
                boolean taskCreated = isElementPresent(driver, By.xpath("//*[contains(text(), '" + taskTitle + "')]"));
                
                if (taskCreated) {
                    System.out.println("  ✅ Add Task Test PASSED");
                } else {
                    System.out.println("  ❌ Add Task Test FAILED - Task not found in list");
                }
            } else {
                System.out.println("  ❌ Login failed - Cannot continue Add Task test");
            }
            
        } finally {
            // Always close the browser
            Thread.sleep(2000); // Give time to see the final state
            driver.quit();
        }
    }
    
    private static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}