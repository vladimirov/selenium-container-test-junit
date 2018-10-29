import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;


import java.io.File;

import static org.rnorth.visibleassertions.VisibleAssertions.assertTrue;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

public class ContainerTestngTest {

    public static BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withDesiredCapabilities(DesiredCapabilities.chrome())
            .withRecordingMode(RECORD_ALL, new File("target"));

    @BeforeClass
    public static void setUp(){
        chrome.start();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        chrome.stop();
    }

    @Test
    public void containerTest() throws InterruptedException {
        RemoteWebDriver driver = chrome.getWebDriver();
        driver.get("http://wordpress.local/");
        driver.findElementById("menu-item-388").click();
        Thread.sleep(3000);
        boolean expectedTextFound = driver.findElementsByCssSelector("p")
                .stream()
                .anyMatch(element -> element.getText().contains("this"));
        assertTrue("The word 'this' is found on a page", expectedTextFound);
    }

}
