package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;


public class Smartphone {

    public WebDriver driver;
      MainPage mainpage;
//    ElectronicsPage electronicspage;
//    SearchPage searchpage;
//    ResultsPage resultspage;
//    FavoritesPage favoritespage;
//    private static final Logger log = Logger.getLogger( SimpleTest.class.getName() );

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        mainpage = PageFactory.initElements(driver, MainPage.class);
//        electronicspage = PageFactory.initElements(driver, ElectronicsPage.class);
//        searchpage = PageFactory.initElements(driver, SearchPage.class);
//        resultspage = PageFactory.initElements(driver, ResultsPage.class);
//        favoritespage = PageFactory.initElements(driver, FavoritesPage.class);
    }

    @AfterTest
    public void tearDown(){
        //driver.quit();
    }



    @Test
    public void openMainPage(){
        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие", "Title of web page is wrong. Please check URL" );
    }

    @Test(dependsOnMethods = "openMainPage")
    public void testCase(){
        mainpage.dismissAlert();

    }

}

