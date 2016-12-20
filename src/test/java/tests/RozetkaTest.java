package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.MainPage;
import pages.Phones;
import pages.PhonesTV;
import pages.ResultsPage;

import java.sql.*;


public class RozetkaTest {

    public WebDriver driver;

    MainPage mainpage;
    PhonesTV phonestv;
    Phones phones;
    ResultsPage resultspage;


    @BeforeTest
    public void setUpDataBase(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        mainpage = PageFactory.initElements(driver, MainPage.class);
        phonestv = PageFactory.initElements(driver, PhonesTV.class);
        phones = PageFactory.initElements(driver, Phones.class);
        resultspage = PageFactory.initElements(driver, ResultsPage.class);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void openMainPage(){
        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        //Assert.assertEquals(driver.getTitle(), "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие", "Title of web page is wrong. Please check URL" );
    }

    @Test(dependsOnMethods = "openMainPage")
    public void testCase() throws SQLException {
        mainpage.dismissAlert();
        mainpage.clickMenuPhones();
        phonestv.clickPhonesLink();
        phones.clickSmartphoneslink();
        resultspage.addToArrayFromResult(3);
        resultspage.setUpDataBase();
        resultspage.save();
        resultspage.tearDownDataBase();



    }

}

