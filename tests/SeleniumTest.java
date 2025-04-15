import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public static void main(String[] args) {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Configure Chrome to run in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Create a new ChromeDriver instance with options
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://localhost");

            WebElement aboutLink = driver.findElement(By.linkText("About"));
            aboutLink.click();

            WebElement aboutText = driver.findElement(By.id("about"));
            String text = aboutText.getText();

            if (text.contains("This is About page")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED: Text not matched");
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

