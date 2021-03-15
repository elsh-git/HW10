import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.paulhammant.ngwebdriver.ByAngular;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class Main {
    private static WebDriver driver1;
    private static NgWebDriver driver_ng;


    @Test
    public void test101() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elad\\drivers\\ChromeDriver.exe");
        driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS); driver1.get("https://dgotlieb.github.io/Selenium/synchronization.html");;
        WebDriverWait wait = new WebDriverWait(driver1, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn"))).click();
        driver1.findElement(By.id("message")).isDisplayed();
    }
    @Test
    public void test102 () throws InterruptedException {
        driver1.findElement(By.id("hidden")).click();
        Thread.sleep(10000);
        driver1.findElement(By.id("finish1")).isDisplayed();
        String output1 = driver1.findElement(By.id("finish1")).getText();
        assertEquals(output1, "My Hidden Element!");
    }
    @Test
    public void test103 (){
        driver1.findElement(By.id("rendered")).click();
        WebDriverWait wait = new WebDriverWait(driver1, 10);
        String output = driver1.findElement(By.id("finish2")).getText();
        assertEquals(output, "This is a new element");
    }
    @Test
    public void test200(){
        driver1.get("https://dgotlieb.github.io/AngularJS/main.html");
        WebElement firstname = driver1.findElement(ByAngular.model("firstName"));
        firstname.clear();
        firstname.sendKeys("Elad");

}
//  3 (answer) - the pageLoadTimeout limits the time that the script allots for a web page to be displayed.
//             If the page loads within the time then the script continues but,
//              If the page does not load within the timeout the script will be stopped by a TimeoutException.

    @Test
    public void test400_pom(){
        int expResolt = 684;
        driver1.get("https://dgotlieb.github.io/WebCalculator/");
        Calc_page calc_page = new Calc_page(driver1);
        calc_page.size_7();
        calc_page.SixOnDisplay();
        calc_page.PressSix();
        calc_page.PressZero();
        calc_page.PressMultiply();
        calc_page.PressSix();
        calc_page.PressMultiply();
        calc_page.PressTwo();
        calc_page.PressEqual();
        calc_page.PressSubtraction();
        calc_page.PressSix();
        calc_page.PressMultiply();
        calc_page.PressSix();
        calc_page.PressEqual();
        assertEquals(calc_page.result(), String.valueOf(expResolt));



    }






}
