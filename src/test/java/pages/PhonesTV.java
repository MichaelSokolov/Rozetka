package pages;


import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PhonesTV extends BaseUtil{

    public PhonesTV(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[contains(@href, '/telefony/')])[1]") WebElement menu_phones;



    public void clickPhonesLink(){
        wait.until(ExpectedConditions.elementToBeClickable(menu_phones));
        menu_phones.click();
    }

}
