package PageObjects;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    @FindBy(xpath = "")
    private WebElement f;
    private WebElement getAvailableExample(String value) {
        By example = By.linkText(value);
        return Utility.getDriver().findElement(example);
    }

    public WelcomePage() {
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public void navigateAvailableExample(String value)
    {
        getAvailableExample(value).click();
    }
}



