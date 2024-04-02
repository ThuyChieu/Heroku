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
        //sort asc first name
        dataTablePage.clickOnHeaderOfTable("First Name");
        String firstNameOriginalDataAsc = String.valueOf(dataTablePage.getFirstNameOriginalList());
        String fisrtNameSortedDataAsc = String.valueOf(dataTablePage.getFirstNameSortedList());
        Assert.assertEquals(firstNameOriginalDataAsc, fisrtNameSortedDataAsc);
        //sort desc first name
        dataTablePage.clickOnHeaderOfTable("First Name");
        String firstNameOriginalDataDesc = String.valueOf(dataTablePage.getFirstNameOriginalList());
        String fisrtNameSortedDataDesc = String.valueOf(dataTablePage.getFirstNameSortedList());
        Assert.assertEquals(firstNameOriginalDataDesc, fisrtNameSortedDataDesc);
        //sort ascv last name
        dataTablePage.clickOnHeaderOfTable("Last Name");
        String lastNameOriginalDataAsc = String.valueOf(dataTablePage.getLastNameOriginalList());
        String lastNameSortedDataAsc = String.valueOf(dataTablePage.getLastNameSortedList());
        Assert.assertEquals(lastNameOriginalDataAsc, lastNameSortedDataAsc);
        //sort desc last name
        dataTablePage.clickOnHeaderOfTable("Last Name");
        String lastNameOriginalDataDesc = String.valueOf(dataTablePage.getLastNameOriginalList());
        String lastNameSortedDataDesc = String.valueOf(dataTablePage.getLastNameSortedList());
        Assert.assertEquals(lastNameOriginalDataDesc, lastNameSortedDataDesc);
        //sort asc email
        dataTablePage.clickOnHeaderOfTable("Email");
        String emailOriginalDataAsc = String.valueOf(dataTablePage.getEmailOriginalList());
        String emailSortedDataAsc = String.valueOf(dataTablePage.getEmailSortedList());
        Assert.assertEquals(emailOriginalDataAsc, emailSortedDataAsc);
        //sort desc email
        dataTablePage.clickOnHeaderOfTable("Email");
        String emailOriginalDataDesc = String.valueOf(dataTablePage.getEmailOriginalList());
        String emailSortedDataDesc = String.valueOf(dataTablePage.getEmailSortedList());
        Assert.assertEquals(emailOriginalDataDesc, emailSortedDataDesc);
        //sort asc due
        dataTablePage.clickOnHeaderOfTable("Due");
        String dueOriginalDataAsc = String.valueOf(dataTablePage.getDueOriginalList());
        String dueSortedDataAsc = String.valueOf(dataTablePage.getDueSortedList());
        Assert.assertEquals(dueOriginalDataAsc, dueSortedDataAsc);
        //sort desc due
        dataTablePage.clickOnHeaderOfTable("Due");
        String dueOriginalDataDesc = String.valueOf(dataTablePage.getDueOriginalList());
        String dueSortedDataDesc = String.valueOf(dataTablePage.getDueSortedList());
        Assert.assertEquals(dueOriginalDataDesc, dueSortedDataDesc);
        //sort asc website
        dataTablePage.clickOnHeaderOfTable("Web Site");
        String webSiteOriginalDataAsc = String.valueOf(dataTablePage.getWebsiteOriginalList());
        String webSiteSortedDataAsc = String.valueOf(dataTablePage.getWebsiteSortedList());
        Assert.assertEquals(webSiteOriginalDataAsc, webSiteSortedDataAsc);
        //sort desc website
        dataTablePage.clickOnHeaderOfTable("Web Site");
        String webSiteOriginalDataDesc = String.valueOf(dataTablePage.getWebsiteOriginalList());
        String webSiteSortedDataDesc = String.valueOf(dataTablePage.getWebsiteSortedList());
        Assert.assertEquals(webSiteOriginalDataDesc, webSiteSortedDataDesc);
    }
}
