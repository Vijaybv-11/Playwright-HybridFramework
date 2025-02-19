package ui.frameworkconstants;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.awt.*;

public class PlaywrightFactory {

    protected Playwright playwright;
    protected Browser browser;
    @Setter
    @Getter
    private  Page page;
    protected LaunchOptions launchOptions;

    @BeforeClass
    @Parameters({"browserType", "headless", "url"})
    public void setup(@Optional("chrome") String browserType, @Optional("false") boolean headless, String url) {
        // Initialize Playwright
        playwright = Playwright.create();

        // Launch the specified browser based on the input 'browserType'
        launchOptions = new LaunchOptions().setChannel(browserType).setHeadless(headless);
        switch (browserType.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium().launch(launchOptions);
                break;
            case "firefox":
                browser = playwright.firefox().launch(launchOptions);
                break;
            case "webkit":
                browser = playwright.webkit().launch(launchOptions);
                break;
            case "msedge":
                browser = playwright.chromium().launch(launchOptions);
            default:
                System.out.println("Unsupported browser type. Launching Chromium by default.");
                browser = playwright.chromium().launch(launchOptions);
        }

        page = browser.newPage();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width =(int) screenSize.getWidth();
        int height =(int) screenSize.getHeight();
        page.setViewportSize(width, height);
        page.navigate(url);
        page.waitForLoadState();
        setPage(page);
    }

    @AfterClass
    // Clean up after tests
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
