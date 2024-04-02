package PageObjects;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DataTablePage {
//    @FindBy(xpath = "//table[@id='table1']/tbody/tr[1]/td[count(//table[@id='table1']//th//span[@text='Last Name']/preceding-sibling::th)+1]")
//    private WebElement f;

    private WebElement getDataTable(String value) {
        By data = By.xpath("//table[@id='table1']/tbody/tr[1]/td[count(//table[@id='table1']//th/span[text()='" + value + "']/../preceding-sibling::th)+1]");
        return Utility.getDriver().findElement(data);
    }

    private WebElement getDataOfColumn(String value) {
        By data = By.xpath("//table[@id='table1']/tbody/tr[1]/td[count(//table[@id='table1']//th/span[text()='" + value + "']/../preceding-sibling::th)+1]");
        return Utility.getDriver().findElement(data);
    }

    public DataTablePage() {
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public String setValueToDataTable(String value)
    {
        String tableValue = getDataTable(value).getText();
        return tableValue;
    }

    public void clickOnHeaderOfTable(String value)
    {
        getDataTable(value).click();
    }
}
