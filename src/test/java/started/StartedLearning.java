package started;

import java.io.IOException;
import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import utils.FileUtilities;

public class StartedLearning{
	FileUtilities fileUtility=new FileUtilities();
	
	Browser browser;
	Page page;
	Playwright playwright;
	
	@org.testng.annotations.Parameters("BrowserName")
	@BeforeMethod
	public void setUp(@Optional("Chrome") String browserName)
	{
		playwright=Playwright.create();
		BrowserType browserType=null;
		
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			browserType=playwright.chromium();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			browserType=playwright.firefox();
		}
		else if(browserName.equalsIgnoreCase("Safari"))
		{
			browserType=playwright.webkit();
		}
		browser=browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		page=browser.newPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		page.clock();
		browser.close();
		playwright.close();
	}
	
	@Test
	public void crossBrowserTesting() throws IOException
	{
		page.navigate("https://influency.codebucketstage.online/brand/");
		 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).fill(fileUtility.readDataFromPropertyFiles("brandUN"));
	}
	
	
	public void video() throws IOException
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(1050, 750).setRecordVideoDir(Paths.get("Videos/")));
		
		Page page = browserContext.newPage();
	
		page.navigate("https://influency.codebucketstage.online/brand/");
		
		page.video().path().toString();
		
		 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*")).fill(fileUtility.readDataFromPropertyFiles("brandUN"));
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password*")).fill(fileUtility.readDataFromPropertyFiles("brandPWD"));
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("icon Campaigns")).click();
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Campaigns")).click();
		
	}

	
	public void screenshot()
	{
		int number=SignUp.generateRandomNumber();
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		
		Page page = browser.newPage();
		
		page.navigate("https://influency.codebucketstage.online/admin/");
		
		page.screenshot();//
		
		page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("screenshot"+number)));
		
		page.locator("email").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshot"+number)));
	}

	public void test01(){

		Browser browser = null;
		Page page = null;
		try {
		 browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		 page = browser.newPage();
		 page.navigate("https://influency.codebucketstage.online/brand");
		 PlaywrightAssertions.assertThat(page).hasTitle("Influency");
		 
//		 page.waitForTimeout(3000);
		 
		 page.locator("#email").fill("avneesh.y+11@thecodebucket.com");//with id
		 page.locator("css=input[id='password']").fill("Password@123");// with css selector
		 page.locator("xpath=//button[@type='submit']").click();//with XPath
		 page.waitForTimeout(3000);
//		 page.getByLabel("").click();
//		 page.getByPlaceholder("").click();
//		 page.getByText("").click(); 
		 
		}
		
		finally{
		 page.close();
		 browser.close();
		}
	}
	public void creatorAutoLoginCred()
	{
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
		        .setStorageStatePath(Paths.get("login.json")));
		      Page page = context.newPage();
		      page.navigate("https://influency.codebucketstage.online/influencer/dashboard");
		      System.out.print(page.locator("xpath=//h1[@class='_greeting_113dr_187']").textContent());
			 PlaywrightAssertions.assertThat(page.locator("xpath=//h1[@class='_greeting_113dr_187']")).hasText("Good morning, Avneesh");
		 }
	}
	
	public void assertionCheck()
	{
		 try (Playwright playwright = Playwright.create()) {
		        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		  	          .setHeadless(false));
		  	        BrowserContext context = browser.newContext();
		  	        Page page = context.newPage();
		  	        page.navigate("https://influency.codebucketstage.online/brand");
		  	        
		  	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		  	    page.pause();
		      String errorText1=page.locator(".errorMessage").textContent();
		      String errorText2=page.locator(".errorMessage").innerText();
		      String errorText3=(String)page.evaluate("");//Handle error text with java script
		      System.out.print(errorText1+ errorText2);
		 }
		 
	}

}
