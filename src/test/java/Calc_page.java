import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Calc_page {
private WebDriver driver;
public Calc_page(WebDriver driver){
    this.driver = driver;
}

public void size_7(){
    driver.findElement(By.id(constants.seven)).getSize();
}
public void SixOnDisplay(){
    driver.findElement(By.id("six")).isDisplayed();
}
public void PressSix(){
    driver.findElement(By.id("six")).click();
}

public void PressZero(){
    driver.findElement((By.id("zero"))).click();
}

public void PressTwo(){
    driver.findElement(By.id("two")).click();
}

public void PressMultiply(){
    driver.findElement(By.id("multiply")).click();
}

public void PressSubtraction(){
    driver.findElement(By.id("minus")).click();
}
public void PressEqual(){
    driver.findElement(By.id("equal")).click();
}

public String result(){
    return driver.findElement(By.id("screen")).getText();
}
}
