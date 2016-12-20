package pages;


import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Phones extends BaseUtil{

    public Phones(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[text()='Смартфоны']") WebElement menu_smartphones;

    public void clickSmartphoneslink(){
        wait.until(ExpectedConditions.elementToBeClickable(menu_smartphones));
        menu_smartphones.click();
    }
}
