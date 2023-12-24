package Homework_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class yopmail {
    WebDriver driver;

    @Test
    public void tugasYopmail(){
        //open browser
        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/wm");

        //isi kolom dan klik enter
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login")));
        driver.findElement(By.name("login")).sendKeys("automationtest");
        driver.findElement(By.name("login")).sendKeys(Keys.RETURN);

        //mengambil data tulisan pada email pertama
        driver.switchTo().frame("ifmail");
        String txtActualEmailPertama = driver.findElement(By.xpath("//div[@class='ellipsis nw b f18']")).getText();
        String txtExpectedEmailPertama = "Welcome to Brick&Bolt! (Service Request ID:CRN299151 )";

        assertTrue(txtActualEmailPertama.contains(txtExpectedEmailPertama));
    }
}
