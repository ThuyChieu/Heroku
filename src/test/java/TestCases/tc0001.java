package TestCases;

import PageObjects.WelcomePage;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.HEROKU_URL;


public class tc0001 extends BaseTest{
    private WelcomePage welcomePage;

    @Test(description = "Verify that the first table has the appropriate data in the first row")
    public void TC01() {

        welcomePage = new WelcomePage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Heroku page");
        WebDriverUtils.navigateToPage(logStep, HEROKU_URL);

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Sortable Data Tables Page");
        welcomePage.navigateAvailableExample("Sortable Data Tables");
    }
}
