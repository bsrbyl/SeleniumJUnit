package practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {

    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim

       */
    static  WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void test1(){
        driver.get("https://www.google.com");
      WebElement sayfaIsmiElementi=driver.findElement(By.xpath("//img[@alt='Google']"));
        System.out.println(sayfaIsmiElementi.getText());
String istenenKelime="Google";
//if (sayfaIsmiElementi.contains(""))
    }
@Test
    public void test2(){
       driver.get("https://www.amazon.com");
       String amazonUrl=driver.getCurrentUrl();
    System.out.println("amazonUrl = " +amazonUrl);
    if(amazonUrl.contains("www.amazon.com")){
        System.out.println("www.amazon.com yazisi vardir PASSED");
    }else{
        System.out.println("www.amazon.com yazisi yoktur FAILED");
    }

}
@AfterClass
    public static void tearDown(){
        driver.quit();
}

}
