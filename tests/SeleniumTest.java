import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost");
            driver.findElement(By.linkText("About")).click();
            String text = driver.findElement(By.id("about")).getText();

            if (text.contains("This is About page")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED: Unexpected content");
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

