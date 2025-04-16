import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumTest {
    public static void main(String[] args) {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Configure Chrome to run in headless mode with a unique user-data-dir
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/temporary-profile-" + System.currentTimeMillis());

        // Create a new ChromeDriver instance with options
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://localhost");

            // Print the page source for debugging
            System.out.println(driver.getPageSource());

            // Wait for the "About Us" link to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement aboutLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("About Us")));
            aboutLink.click();

            // Wait for the paragraph with specific ID to be visible
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("PID-ab2-pg")));
            WebElement para = driver.findElement(By.id("PID-ab2-pg"));
            String actualText = para.getText();

            String expectedText = "This is about page. Lorem Ipsum Dipsum";
            if (actualText.contains(expectedText)) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED: Text not matched");
                System.out.println("Actual text: " + actualText);
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("TEST FAILED: Exception occurred");
            e.printStackTrace();
            System.exit(1);
        } finally {
            driver.quit();
        }
    }
}
