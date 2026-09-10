package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CRMPage {

    private Page page;

    public CRMPage(Page page) {
        this.page = page;
    }

    public void openCRM() {

        page.locator(
            "xpath=//span[normalize-space()='CRM']"
        ).click();
    }

    public void openContactedInfluencers() {

        page.locator(
            "xpath=//button[normalize-space()='Influencers']"
        ).click();
    }

    public void goToLastPage() {

        Locator nextButton =
            page.locator("button[aria-label='Next page']");

        while (!nextButton.isDisabled()) {

            nextButton.click();

            page.waitForLoadState();
        }
    }

    public String getLastEntryName() {

        Locator lastEntry =
            page.locator("tbody tr td:first-child").last();

        return lastEntry.textContent();
    }

    public void verifyLastEntry(String expectedName) {

        Locator lastEntry =
            page.locator("tbody tr td:first-child").last();

        lastEntry.waitFor();

        if (!lastEntry.textContent().equals(expectedName)) {

            throw new AssertionError(
                "Expected: " + expectedName
                + " but found: " + lastEntry.textContent()
            );
        }
    }
}