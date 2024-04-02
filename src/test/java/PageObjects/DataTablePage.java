package PageObjects;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DataTablePage {

    private WebElement getDataTable(String value) {
        By data = By.xpath("//table[@id='table1']/tbody/tr[1]/td[count(//table[@id='table1']//th/span[text()='" + value + "']/../preceding-sibling::th)+1]");
        return Utility.getDriver().findElement(data);
    }

    private String getFirstNameColumn(String value) {
        By data = By.xpath("//*[@id='table1']/tbody/tr[" + value + "]/td[2]");
        return Utility.getDriver().findElement(data).getText();
    }

    private String getLastNameColumn(String value) {
        By data = By.xpath("//*[@id='table1']/tbody/tr[" + value + "]/td[1]");
        return Utility.getDriver().findElement(data).getText();
    }

    private String getEmailColumn(String value) {
        By data = By.xpath("//*[@id='table1']/tbody/tr[" + value + "]/td[3]");
        return Utility.getDriver().findElement(data).getText();
    }

    private String getDueColumn(String value) {
        By data = By.xpath("//*[@id='table1']/tbody/tr[" + value + "]/td[4]");
        return Utility.getDriver().findElement(data).getText();
    }

    private String getWebsiteColumn(String value) {
        By data = By.xpath("//*[@id='table1']/tbody/tr[" + value + "]/td[5]");
        return Utility.getDriver().findElement(data).getText();
    }

    private WebElement getFirstRow(String value) {
        By data = By.xpath("//table[@id='table1']//th/span[text()='" + value + "']");
        return Utility.getDriver().findElement(data);
    }

    public DataTablePage() {
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public String setValueToDataTable(String value) {
        String tableValue = getDataTable(value).getText();
        return tableValue;
    }

    public void clickOnHeaderOfTable(String value) {
        getFirstRow(value).click();
    }

    public List<String> getFirstNameOriginalList() {
        List<String> originalList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            originalList.add(getFirstNameColumn(String.valueOf(i)));
        }
        return originalList;
    }

    public List<String> getFirstNameSortedList() {
        List<String> sortedList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            sortedList.add(getFirstNameColumn(String.valueOf(i)));
        }
        return sortedList;
    }

    public List<String> getLastNameOriginalList() {
        List<String> originalList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            originalList.add(getLastNameColumn(String.valueOf(i)));
        }
        return originalList;
    }

    public List<String> getLastNameSortedList() {
        List<String> sortedList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            sortedList.add(getLastNameColumn(String.valueOf(i)));
        }
        return sortedList;
    }

    public List<String> getEmailOriginalList() {
        List<String> originalList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            originalList.add(getEmailColumn(String.valueOf(i)));
        }
        return originalList;
    }

    public List<String> getEmailSortedList() {
        List<String> sortedList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            sortedList.add(getEmailColumn(String.valueOf(i)));
        }
        return sortedList;
    }

    public List<String> getWebsiteOriginalList() {
        List<String> originalList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            originalList.add(getWebsiteColumn(String.valueOf(i)));
        }
        return originalList;
    }

    public List<String> getWebsiteSortedList() {
        List<String> sortedList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            sortedList.add(getWebsiteColumn(String.valueOf(i)));
        }
        return sortedList;
    }

    public List<String> getDueOriginalList() {
        List<String> originalList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            originalList.add(getDueColumn(String.valueOf(i)));
        }
        return originalList;
    }

    public List<String> getDueSortedList() {
        List<String> sortedList = new ArrayList<>();
        int i;
        for (i = 1; i <= 4; i++) {
            sortedList.add(getDueColumn(String.valueOf(i)));
        }
        return sortedList;
    }
}
