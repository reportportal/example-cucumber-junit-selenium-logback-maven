
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.fail;

public class AmazonTestSteps {

    private Logger logger = LoggerFactory.getLogger(AmazonTestSteps.class);

    @Given("^User opens page$")
    public void userOpenPage() {
        TestBase.getDriver().get("https://www.amazon.com/");
        logger.info("user is opening main page");

        delay();
    }

    @Then("^User typing a search query$")
    public void userTypingSearchQuery() {

        logger.info("user typing a search query");
        TestBase
                .getDriver()
                .findElement(By.id("twotabsearchtextbox"))
                .sendKeys("apple");

        delay();
    }


    @When("^User clicks search button$")
    public void userClicksSearchButton() {

        logger.info("user clicks search button");

        TestBase
                .getDriver()
                .findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"))
                .click();

//        delay();

        // fail this step to report screenshot to reportportal
        fail();
    }

    private void delay() {

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
