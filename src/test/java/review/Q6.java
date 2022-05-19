package review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully
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
           public void test01() throws InterruptedException {
       //2. 'http://automationexercise.com' url'sine gidin
       driver.get("http://automationexercise.com");

       //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
       driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();


       //4. 'Bize Ulaşın' düğmesine tıklayın
       driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

       //5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
       driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed();

       //6. Adı, e-posta adresini, konuyu ve mesajı girin

       driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("busra");
       driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("asdfc@gmail.com");
       driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("kart islemi");
       driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("kart islemlerinde hata veriyor");
       //7. Dosya yükle
       driver.findElement(By.xpath("//input[@type='file']")).submit();
       Thread.sleep(3000);
       driver.switchTo().alert().dismiss();
       //8. 'Gönder' düğmesini tıklayın
       driver.findElement(By.xpath("//input[@type='submit']")).click();
       //9. Tamam düğmesine tıklayın
       driver.switchTo().alert().accept();
       //10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
       driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]")).isDisplayed();
       //11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
       driver.findElement(By.xpath("(//*[text()=' Home'])[2]")).click();
       driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed();


   }





}
