import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    private static WebDriver driver;

    private static final String CHROME_KEY="webdriver.chrome.driver";
    private static final String CHROME_VALUE="./drivers/chromedriver.exe";

    @Before
    public void before() {

        System.setProperty(CHROME_KEY, CHROME_VALUE);

        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            if (screenshot != null ) {
                scenario.embed(screenshot, "image/png");
            }
        }
        driver.close();
    }
}
