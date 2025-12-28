import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class uploadfileDay4 {
    public static void main(String[] args){
        Playwright pl=Playwright.create();
        Browser browser= pl.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page=browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/upload");
        page.locator("//input[@id='file-upload']").setInputFiles(Paths.get("C:\\Users\\admin\\Downloads\\Vinay.jpeg"));

    }
}
