import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;

import java.util.regex.Pattern;

public class Day2 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page=browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        System.out.println("title = "+page.title());
        Assert.assertEquals(page.title(),"Learn Automation Courses");
        page.locator("//div[@class='content']//following-sibling::input[@id='email1']").fill("sarveshmishra1515@gmail.com");
        page.locator("//div[@class='content']//following-sibling::input[@id='password1']").fill("Utkarsh@123");
        page.locator("//div[@class='content']//following-sibling::button[@class='submit-btn']").click();
        String cart=page.locator("//div[@class='navbar-menu-links']/button[contains(text(),'Cart')]").textContent();
       System.out.println(cart);
       Assert.assertEquals(cart,"Cart");
       page.locator("//div[@class='navbar-menu-links']/img[@alt='menu']").click();
       page.locator("//div[@class='navbar-menu-links sidebar-menu']//following::button[contains(text(),'Sign out')]").click();
        PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
        page.close();
        browser.close();
        playwright.close();
    }
}
