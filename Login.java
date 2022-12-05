package exam;



import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Login {
            
        WebDriver driver;
        @BeforeClass
        public void setup()
        {
            driver= new ChromeDriver();
            driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



       }
        
        @AfterClass
        public void tearDown()
        {
            driver.quit();
        }
        
        @Test
        public void verifyInvalidCredentials()
        {
            driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
            driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("KDSHJ");



           driver.findElement(By.xpath("//input[@name='Submit']")).click();
            WebElement ele2=driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
            Assert.assertTrue(ele2.isDisplayed());
        }
        
        @Test
        public void verifyValidCredentials() throws InterruptedException
        {
            driver.findElement(By.xpath("//input[@name='txtUsername']")).clear();
            driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
            driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
            driver.findElement(By.xpath("//input[@name='Submit']")).click();
            Thread.sleep(5000);
            String url=driver.getCurrentUrl();
            System.out.println("URL is "+url);
            boolean status=url.contains("dashboard");
            System.out.println("Status is "+status);
            Assert.assertTrue(status);
            
        }
}