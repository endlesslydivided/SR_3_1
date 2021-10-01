import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
public class test
{
        private static ChromeDriverService service;
        private WebDriver driver;

        @BeforeClass
        public static void createAndStartService() throws IOException {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("..\\Lab10\\src\\resources\\chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            service.start();
        }

        @AfterClass
        public static void stopService() {
            service.stop();
        }

        @Before
        public void createDriver() {
            driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        }

        @After
        public void quitDriver() {
            driver.quit();
        }

        @Test
        public void testGoogleSearch() {
            driver.get("http://www.google.com/itechart");
        }
}
