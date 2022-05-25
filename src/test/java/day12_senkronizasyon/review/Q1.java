package day12_senkronizasyon.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q1 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
       // driver.close();
    }
    @Test
    public void test01(){
        //1. Tarayıcıyı başlatın
        // 2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

//3. Ana sayfanın başarıyla görünür olduğunu doğrulayın

//4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement yeniGiris=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        yeniGiris.isDisplayed();

//6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("busra");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("busraboyali123@gmail.com");

//7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Signup']")).submit();
//8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();

//9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456789");


        WebElement drabdown1= driver.findElement(By.xpath("//select[@id='days']"));
        Select select1=new Select(drabdown1);
        select1.selectByVisibleText("30");

        WebElement drabdown2=driver.findElement(By.xpath("//select[@id='months']"));
        Select select2=new Select(drabdown2);
        select2.selectByValue("7");


        WebElement drabdown3=driver.findElement(By.xpath("//select[@id='years']"));
        Select select3=new Select(drabdown3);
        select3.selectByValue("1995");


//10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
//11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@name='optin']")).click();
//12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("busra");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("boyaci");

        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Street address, P.O. Box, Company name, etc.");

        WebElement ulke=driver.findElement(By.xpath("//select[@id='country']"));
        Select select4=new Select(ulke);
        select4.selectByValue("Canada");

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("ontario");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("toronto");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("66777");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("+49050500000000");


//13. 'Hesap Oluştur düğmesini' tıklayın
driver.findElement(By.xpath("//*[text()='Create Account']")).click();


//14. 'HESAP OLUŞTURULDU!' görünür
//15. 'Devam' düğmesini tıklayın
//16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
//17. 'Hesabı Sil' düğmesini tıklayın
//18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın


    }




}
