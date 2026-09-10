package pages;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import utils.FileUtilities;
import utils.PlaywrightManager;

public class BrandSignupPage {

    private final Page page;
    private final FileUtilities fileUtility;

    private String brandName;
    private String email;
    int number = started.SignUp.generateRandomNumber();

    public BrandSignupPage() {
        this.page = PlaywrightManager.getPage();
        this.fileUtility = new FileUtilities();
    }

    // ---------------------------------------------------------
    // Test data
    // ---------------------------------------------------------

    public void generateBrandData() {

        int number = started.SignUp.generateRandomNumber();

        brandName = "Brand" + number;
        email = "avneesh.y+" + number + "@thecodebucket.com";
    }

    public String getBrandName() {
        return brandName;
    }

    public String getEmail() {
        return email;
    }

    // ---------------------------------------------------------
    // Brand Signup
    // ---------------------------------------------------------

    public void openBrandSignupPage() throws Exception {

        page.navigate(
            fileUtility.readDataFromPropertyFiles("brandURL")
        );
    }

    public void verifyPageTitle() {

        PlaywrightAssertions
                .assertThat(page)
                .hasTitle("Influency");
    }

    public void clickCreateAccount() {

        page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("Create an account")
        ).click();
    }

    public void enterEmail() {

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Email")
        ).fill(email);
    }

    public void sendOTP() {

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Send OTP")
        ).click();
        page.waitForTimeout(2000);
    }

    public void enterOTP() {

        Locator otpBoxes =
                page.getByRole(AriaRole.TEXTBOX);

        otpBoxes.nth(0).fill("1");
        otpBoxes.nth(1).fill("2");
        otpBoxes.nth(2).fill("3");
        otpBoxes.nth(3).fill("4");
        otpBoxes.nth(4).fill("5");
    }

    public void verifyOTP() {

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Verify")
        ).click();
    }

    // ---------------------------------------------------------
    // Basic details
    // ---------------------------------------------------------

    public void enterBasicDetails() {

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Brand Name*")
                        .setExact(true)
        ).fill(brandName);

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Password*")
                        .setExact(true)
        ).fill("Password@123");

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Confirm Password*")
        ).fill("Password@123");

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Save & Next")
        ).click();
    }

    // ---------------------------------------------------------
    // Profile image
    // ---------------------------------------------------------

    public void uploadBrandImage() {

        page.locator(
                "//div[@class='_custom_design_1xh91_177']"
        ).setInputFiles(
                Paths.get("src/test/resources/images.jpeg")
        );

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Crop & Confirm")
        ).click();
        page.waitForTimeout(3000);
    }

    // ---------------------------------------------------------
    // Business details
    // ---------------------------------------------------------

    public void enterBusinessDetails() {

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Describe your brand's primary")
        ).fill("test");

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("What is the number of")
        ).fill("30");

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Continue")
        ).click();
    }

    // ---------------------------------------------------------
    // GST / PAN
    // ---------------------------------------------------------

    public void confirmNoGSTAndPAN() {

        page.getByRole(
                AriaRole.RADIO,
                new Page.GetByRoleOptions()
                        .setName(
                            "I confirm that my company does not have a GST or Shop License number."
                        )
        ).check();

        page.getByRole(
                AriaRole.RADIO,
                new Page.GetByRoleOptions()
                        .setName(
                            "I confirm that my company does not have a PAN"
                        )
        ).check();
    }

    public void provideGSTDetails() {

        page.getByRole(
            AriaRole.RADIO,
            new Page.GetByRoleOptions().setName("Yes")
        ).first().check();

        page.getByRole(
            AriaRole.TEXTBOX,
            new Page.GetByRoleOptions()
                .setName("GST or Shop License Number*")
        ).fill("GSTIN" + number);

        page.getByLabel("Upload File")
            .locator("div")
            .setInputFiles(
                Paths.get("src/test/resources/pdf_file-sample_150kB.pdf")
            );

        page.waitForTimeout(3000);
    }
    
    public void providePANDetails() {

        page.getByRole(
            AriaRole.RADIO,
            new Page.GetByRoleOptions().setName("Yes")
        ).nth(1).check();

        page.locator("div")
            .filter(
                new Locator.FilterOptions()
                    .setHasText(
                        Pattern.compile(
                            "^Click to upload \\*Only PDF\\. Maximum size is 2 MB\\*$"
                        )
                    )
            )
            .nth(2)
            .setInputFiles(
                Paths.get("src/test/resources/pdf_file-sample_150kB.pdf")
            );

        page.waitForTimeout(3000);
    }
    // ---------------------------------------------------------
    // Point of Contact
    // ---------------------------------------------------------

    public void enterPOCDetails() {

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("POC (Point of Contact) Name*")
        ).fill("Avneesh");

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("POC (Point of Contact) Email*")
        ).fill("avniy@gmai.com");

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("POC (Point of Contact) Phone*")
        ).fill("1234575765");

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Website")
        ).fill(
            "https://influency.codebucketstage.online/brand/onboarding"
        );
    }

    // ---------------------------------------------------------
    // Location
    // ---------------------------------------------------------

    public void enterLocation() {

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Location*")
        ).click();

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Bekal")
        ).click();

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Continue")
        ).click();
    }

    // ---------------------------------------------------------
    // Instagram
    // ---------------------------------------------------------

    public void enterInstagramDetails() {

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Instagram User Name")
        ).fill(
            "Testing" + brandName.replace("Brand", "")
        );

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Number of Followers")
        ).fill("2,3232");

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Number of Following")
        ).fill("3");

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Number of Posts")
        ).fill("23");

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Continue")
        ).click();

        page.getByText("Food & Beverages").click();
    }

    // ---------------------------------------------------------
    // Finish setup
    // ---------------------------------------------------------

    public void finishSetup() {

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Finish Setup")
        ).click();

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Check Status")
        ).click();

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Refresh Status")
        ).click();
    }

    // ---------------------------------------------------------
    // Logout
    // ---------------------------------------------------------

    public void logoutBrand() {

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Log Out")
        ).click();
    }

    // ---------------------------------------------------------
    // Admin verification
    // ---------------------------------------------------------

    public void openAdmin() throws Exception {

        page.navigate(
            fileUtility.readDataFromPropertyFiles("adminURL")
        );
    }

    public void adminLogin() throws Exception {

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Email*")
        ).fill(
            fileUtility.readDataFromPropertyFiles("adminUN")
        );

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Password*")
        ).fill(
            fileUtility.readDataFromPropertyFiles("adminPWD")
        );

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Login")
        ).click();
    }

    public void openBrands() {

        page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("icon Brands")
        ).click();
    }

    public void openCreatedBrand() {

        page.getByRole(
                AriaRole.LINK
        ).filter(
                new Locator.FilterOptions()
                        .setHasText(brandName)
        ).click();
    }

    public void verifyCreatedBrand() {

        PlaywrightAssertions.assertThat(
                page.getByRole(
                        AriaRole.HEADING,
                        new Page.GetByRoleOptions()
                                .setName(brandName)
                )
        ).isVisible();
    }

    public void adminLogout() {

        page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("Super Admin")
        ).click();

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Log Out")
        ).click();

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Yes")
        ).click();
    }
}