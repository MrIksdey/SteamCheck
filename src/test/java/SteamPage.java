import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class SteamPage {

    private WebDriverWait wait = new WebDriverWait(Singleton.driver(), Duration.ofSeconds(10));
    private WebElement privacyPolicyLink = Singleton.driver().findElement(By.linkText("Privacy Policy"));
    private WebElement searchBar = Singleton.driver().findElement(By.id("store_nav_search_term"));
    private WebElement clickSearchButton = Singleton.driver().findElement(By.id("store_search_link"));
    private String newTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
    private String sendEnter = Keys.chord(Keys.RETURN);

    public void scrollToTheBottom()
    {
        JavascriptExecutor jse = (JavascriptExecutor) Singleton.driver();
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void openPrivacyPolicy()
    {
        privacyPolicyLink.sendKeys(newTab);
    }

    public void switchTabs()
    {
        ArrayList<String> tabs2 = new ArrayList<String> (Singleton.driver().getWindowHandles());
        Singleton.driver().switchTo().window(tabs2.get(0));
        Singleton.driver().close();
        Singleton.driver().switchTo().window(tabs2.get(1));
    }

    public void searchGame (String game)
    {
        searchBar.sendKeys(game);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("store_search_link")));
        clickSearchButton.sendKeys(sendEnter);
    }

    public String titleOfPage ()
    {
        String title = Singleton.driver().getTitle();
        return title;
    }
}