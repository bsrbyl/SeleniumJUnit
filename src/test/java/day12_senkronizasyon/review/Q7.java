package day12_senkronizasyon.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q7 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Test Cases' button
    //5. Verify user is navigated to test cases page successfully
    WebDriver driver;
    @Before
    public void setUp(){
        //1. Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
       driver.close();
    }

    @Test
    public void test01() {
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();
        //4. 'Test Vakaları' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        //5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        driver.findElement(By.xpath("//*[text()='Test Cases']")).isDisplayed();
    }


}
