package pages;

import com.microsoft.playwright.Page;

import utils.FileUtilities;

public class AdminLoginPage {

    private Page page;
    private FileUtilities fileUtility;

    public AdminLoginPage(Page page) {

        this.page = page;
        this.fileUtility = new FileUtilities();
    }

    public void openAdminLogin() throws Exception {

        page.navigate(
            fileUtility.readDataFromPropertyFiles("adminURL")
        );
    }

    public void login() throws Exception {

        page.locator("#email").fill(
            fileUtility.readDataFromPropertyFiles("adminUN")
        );

        page.locator("#password").fill(
            fileUtility.readDataFromPropertyFiles("adminPWD")
        );

        page.locator(
            "button[aria-label='Login'] span"
        ).click();
    }
}