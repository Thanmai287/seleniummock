package exam;



import java.io.IOException;
import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Task1 {
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
    public void createEmployee() throws InterruptedException, IOException
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
        driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Thanmai");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Reddy");
       // Actions act=new Actions(driver);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(2000);
        WebElement e=driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']"));
        Assert.assertFalse(e.isEnabled());
        
        driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Thanmai reddy");
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        WebElement checkBoxElement = driver.findElement(By.xpath("//input[@name='chkSelectRow[]']"));
        boolean isSelected = checkBoxElement.isSelected();
                
        if(isSelected == false) {
            checkBoxElement.click();
        }
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();        
        
        }



}