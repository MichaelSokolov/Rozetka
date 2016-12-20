package pages;


import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseUtil{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='notificationPanelBlock']") WebElement alert_dismiss;
    @FindBy(xpath = "//*[@id='3361']/a") WebElement menu_item_phones;

    public void dismissAlert(){
        wait.until(ExpectedConditions.visibilityOf(alert_dismiss));
        alert_dismiss.click();
    }

    public void clickMenuPhones(){
        wait.until(ExpectedConditions.elementToBeClickable(menu_item_phones));
        menu_item_phones.click();
    }











}
