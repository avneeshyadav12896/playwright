package bddhooks;

import com.microsoft.playwright.Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.PlaywrightManager;

public class BDDHooks {

    @Before
    public void setUp() {

        System.out.println("Starting Playwright browser...");

        PlaywrightManager.startBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {

        Page page = PlaywrightManager.getPage();

        if (scenario.isFailed() && page != null) {

            byte[] screenshot = page.screenshot(
                new Page.ScreenshotOptions()
                    .setFullPage(true)
            );

            scenario.attach(
                screenshot,
                "image/png",
                "Failure Screenshot"
            );
        }

        System.out.println("Closing Playwright browser...");

        PlaywrightManager.closeBrowser();
    }
}