package TestCases;

import PageObjects.DataTablePage;
import PageObjects.WelcomePage;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.HEROKU_URL;


public class tc0001 extends BaseTest {
    private WelcomePage welcomePage;
    private DataTablePage dataTablePage;

    @Test(dataProvider = "getDataForTest", description = "Verify that the first row of the table has the appropriate data")
    public void TC01(Hashtable<String, String> data) {
        String availableExample = data.get("AvailableExample");
        String lastNameExpected = data.get("LastName");
        String firstNameExpected = data.get("FirstName");
        String emailExpected = data.get("Email");
        String dueExpected = data.get("Due");
        String websiteExpected = data.get("Website");

        welcomePage = new WelcomePage();
        dataTablePage = new DataTablePage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Heroku page");
        WebDriverUtils.navigateToPage(logStep, HEROKU_URL);

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Sortable Data Tables Page");
        welcomePage.navigateAvailableExample(availableExample);

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Check the first row of the table has the appropriate data");
        String lastName = dataTablePage.setValueToDataTable("Last Name");
        String firstName = dataTablePage.setValueToDataTable("First Name");
        String email = dataTablePage.setValueToDataTable("Email");
        String due = dataTablePage.setValueToDataTable("Due");
        String website = dataTablePage.setValueToDataTable("Web Site");

        Assert.assertEquals(lastName, lastNameExpected, "Last name is not the same as expected");
        Assert.assertEquals(firstName, firstNameExpected, "First name is not the same as expected");
        Assert.assertEquals(email, emailExpected, "Email is not the same as expected");
        Assert.assertEquals(due, dueExpected, "Due is not the same as expected");
        Assert.assertEquals(website, websiteExpected, "Website is not the same as expected");

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Check the data in the columns is sorted ASC/DESC properly");
        dataTablePage.clickOnHeaderOfTable("First Name");
    }
}
