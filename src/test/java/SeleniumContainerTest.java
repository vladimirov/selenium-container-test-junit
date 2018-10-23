import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

import static org.rnorth.visibleassertions.VisibleAssertions.assertTrue;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

/**
 * Simple example of plain Selenium usage.
 */
public class SeleniumContainerTest {

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withDesiredCapabilities(DesiredCapabilities.chrome())
            .withRecordingMode(RECORD_ALL, new File("target"));

    @Test
    public void simplePlainSeleniumTest() throws InterruptedException {
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://localhost/wordpress-test/");
        Thread.sleep(3000);
//        WebElement scrollButton = driver.findElementByClassName("menu-scroll-down");
//        scrollButton.click();
//        WebElement searchInput = driver.findElementByClassName("search-form");
//        searchInput.sendKeys("test");
//        searchInput.submit();
//        boolean expectedTextFound = driver.findElementsByCssSelector("p")
//                .stream()
//                .anyMatch(element -> element.getText().contains("Lorem"));
//        assertTrue("The word 'Lorem' is found on a page", expectedTextFound);
    }
}
