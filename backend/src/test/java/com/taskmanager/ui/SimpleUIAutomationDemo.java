package com.taskmanager.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

/**
 * Simplified standalone UI automation demo with minimal dependencies
 */
public class SimpleUIAutomationDemo {

    private static final String BASE_URL = "http://localhost:5173";
    
    public static void main(String[] args) {
        System.out.println("🚀 Starting Simple UI Automation Demo");
        
        // Set path to ChromeDriver - you may need to adjust this path
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\Avishka\\.cache\\selenium\\chromedriver\\win64\\135.0.7049.114\\chromedriver.exe");
        
        // Configure Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        // Create WebDriver instance
        WebDriver driver = null;
        
        try {
            driver = new ChromeDriver(options);
            
            // Maximize browser window
            driver.manage().window().maximize();
            
            // Run registration test
            runRegistrationDemo(driver);
            
            // Short pause between tests
            Thread.sleep(2000);
            
            // Run add task test
            runAddTaskDemo(driver);
            
            System.out.println("✅ UI Automation Demo completed successfully!");
            
        } catch (Exception e) {
            System.out.println("❌ Error in UI Automation: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close browser
            if (driver != null) {
                try {
                    Thread.sleep(5000); // Keep browser open for 5 seconds at the end
                    driver.quit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private static void runRegistrationDemo(WebDriver driver) throws InterruptedException {
        System.out.println("\n📝 DEMO 1: User Registration Flow");
        
        // Step 1: Navigate to homepage
        System.out.println("  ▶️ browser.get(\"" + BASE_URL + "\")");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        
        // Step 2: Find and click signup link
        System.out.println("  ▶️ browser.findElement(By.linkText(\"Sign Up\"))");
        WebElement signupLink = driver.findElement(By.linkText("Sign Up"));
        System.out.println("  ▶️ signupLink.click()");
        signupLink.click();
        Thread.sleep(1000);
        
        // Step 3: Generate random username
        String username = "testuser" + new Random().nextInt(10000);
        String email = username + "@example.com";
        String password = "Test@123";
        
        // Step 4: Fill registration form
        System.out.println("  ▶️ browser.findElement(By.name(\"username\"))");
        WebElement usernameField = driver.findElement(By.name("username"));
        System.out.println("  ▶️ usernameField.sendKeys(\"" + username + "\")");
        usernameField.sendKeys(username);
        Thread.sleep(1000);
        
        System.out.println("  ▶️ browser.findElement(By.name(\"email\"))");
        WebElement emailField = driver.findElement(By.name("email"));
        System.out.println("  ▶️ emailField.sendKeys(\"" + email + "\")");
        emailField.sendKeys(email);
        Thread.sleep(1000);
        
        System.out.println("  ▶️ browser.findElement(By.name(\"password\"))");
        WebElement passwordField = driver.findElement(By.name("password"));
        System.out.println("  ▶️ passwordField.sendKeys(\"" + password + "\")");
        passwordField.sendKeys(password);
        Thread.sleep(1000);
        
        // Step 5: Submit form
        System.out.println("  ▶️ browser.findElement(By.xpath(\"//button[@type='submit']\"))");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        System.out.println("  ▶️ submitButton.click()");
        submitButton.click();
        Thread.sleep(3000);
        
        // Step 6: Verify result
        System.out.println("  ▶️ Verifying registration result");
        if (driver.getCurrentUrl().contains("login")) {
            System.out.println("  ✅ REGISTRATION TEST PASSED - Redirected to login page");
        } else {
            System.out.println("  ℹ️ Current URL: " + driver.getCurrentUrl());
        }
    }
    
    private static void runAddTaskDemo(WebDriver driver) throws InterruptedException {
        System.out.println("\n📝 DEMO 2: Add Task Flow");
        
        // Step 1: Navigate to homepage
        System.out.println("  ▶️ browser.get(\"" + BASE_URL + "\")");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        
        // Step 2: Click on Login link
        System.out.println("  ▶️ browser.findElement(By.linkText(\"Login\"))");
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        System.out.println("  ▶️ loginLink.click()");
        loginLink.click();
        Thread.sleep(1000);
        
        // Step 3: Login with test account
        System.out.println("  ▶️ Logging in with test account");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testuser");
        Thread.sleep(500);
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("password123");
        Thread.sleep(500);
        
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        
        // Step 4: Look for Add Task button
        try {
            System.out.println("  ▶️ Looking for Add Task button");
            WebElement addTaskButton = driver.findElement(By.xpath("//button[contains(text(), 'Add Task')]"));
            System.out.println("  ▶️ addTaskButton.click()");
            addTaskButton.click();
            Thread.sleep(1000);
            
            // Step 5: Fill task details
            String taskTitle = "UI Test Task " + new Random().nextInt(1000);
            System.out.println("  ▶️ Entering task title: " + taskTitle);
            
            WebElement titleField = driver.findElement(By.name("title"));
            titleField.sendKeys(taskTitle);
            Thread.sleep(1000);
            
            WebElement descField = driver.findElement(By.name("description"));
            descField.sendKeys("This task was created by Selenium automation");
            Thread.sleep(1000);
            
            // Step 6: Submit task
            System.out.println("  ▶️ Submitting new task");
            WebElement createButton = driver.findElement(By.xpath("//button[contains(text(), 'Create')]"));
            createButton.click();
            Thread.sleep(3000);
            
            // Step 7: Verify task was added
            System.out.println("  ▶️ Checking if task was created");
            try {
                WebElement taskElement = driver.findElement(By.xpath("//*[contains(text(), '" + taskTitle + "')]"));
                System.out.println("  ✅ ADD TASK TEST PASSED - Task found in list");
            } catch (Exception e) {
                System.out.println("  ❌ ADD TASK TEST FAILED - Task not found");
            }
            
        } catch (Exception e) {
            System.out.println("  ℹ️ Could not find Add Task button, may need different credentials");
            System.out.println("  ℹ️ Current page source preview: " + 
                driver.getPageSource().substring(0, Math.min(300, driver.getPageSource().length())));
        }
    }
}