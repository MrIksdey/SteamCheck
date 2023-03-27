import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchedGames {
    private WebDriverWait wait = new WebDriverWait(Singleton.driver(), Duration.ofSeconds(10));
    private WebElement searchBarSteamResults = Singleton.driver().findElement(By.xpath("//*[@class='searchbar_left']//input[1]"));
    private WebElement firstSearchResult = Singleton.driver().findElement(By.xpath("//*[@id='search_resultsRows']//a[1]//span[@class='title']"));
    private WebElement secondSearchResult = Singleton.driver().findElement(By.xpath("//*[@id='search_resultsRows']//a[2]//span[@class='title']"));
    private WebElement searchBar = Singleton.driver().findElement(By.id("store_nav_search_term"));  // need to add because of: "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document"
    private WebElement clickSearchButton = Singleton.driver().findElement(By.id("store_search_link"));
    private String sendEnter = Keys.chord(Keys.RETURN);

    public String titleOfPage ()
    {
        String title = Singleton.driver().getTitle();
        return title;
    }

    public String searchBar ()
    {
        String inputSearchBar = searchBarSteamResults.getAttribute("value");
        return inputSearchBar;
    }

    public String firstName ()
    {
        String firstResult = firstSearchResult.getText();
        return firstResult;
    }

    public String secondGame ()
    {
        String secondResult = secondSearchResult.getText();
        return secondResult;
    }

    public void searchSecondGame ()
    {
        searchBar.sendKeys(secondGame());
        wait.until(ExpectedConditions.elementToBeClickable(By.id("store_search_link")));
        clickSearchButton.sendKeys(sendEnter);
    }

}
