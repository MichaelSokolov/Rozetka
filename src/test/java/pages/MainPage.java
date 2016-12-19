package pages;


import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseUtil{



    @FindBy(xpath = "//div[@class='notificationPanelBlock']") WebElement alert_dismiss;
    @FindBy(xpath = "//a[@href='/lv/']") WebElement link_ToSwitchLv;
    @FindBy(xpath = "//h2/a[@href='/ru/electronics/']") WebElement button_MenuElectronics;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void dismissAlert(){
        wait.until(ExpectedConditions.visibilityOf(alert_dismiss));
        alert_dismiss.click();
    }
    public void clickMenuElectronics (){
        button_MenuElectronics.click();
    }








}
