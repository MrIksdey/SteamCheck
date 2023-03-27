import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SecondResultsOfSearchedGames {

    private WebElement searchBarSteamResults = Singleton.driver().findElement(By.xpath("//*[@class='searchbar_left']//input[1]"));
    private List<WebElement> searchResultsTitle = Singleton.driver().findElements(By.xpath("//*[@id='search_resultsRows']//a//span[@class='title']"));
    private List<WebElement> searchResultsReleaseDate = Singleton.driver().findElements(By.xpath("//*[@id='search_resultsRows']//a//div[contains(@class, 'search_released')]"));
    private List<WebElement> searchResultsPrice = Singleton.driver().findElements(By.xpath("//*[@id='search_resultsRows']//a//div[@class='col search_price  responsive_secondrow']"));
    private List<WebElement> searchResultsReviews = Singleton.driver().findElements(By.xpath("//*[@id='search_resultsRows']//a//div[contains(@class, 'search_reviewscore')]//span"));
    private List<WebElement> searchResultsPlatforms1 = Singleton.driver().findElements(By.xpath("//*[@id='search_resultsRows']//a[1]//div[contains(@class, 'search_name')]//div//span"));
    private List<WebElement> searchResultsPlatforms2 = Singleton.driver().findElements(By.xpath("//*[@id='search_resultsRows']//a[2]//div[contains(@class, 'search_name')]//div//span"));

    public String searchBar ()
    {
        String inputSearchBar = searchBarSteamResults.getAttribute("value");
        return inputSearchBar;
    }

    public String resultListOfGames ()
    {
        for (int i = 0; i < searchResultsTitle.size(); i++)
        {
            String listOfResults = searchResultsTitle.get(i).getText();
            return listOfResults;
        }
        return null;
    }

    public String gamesData1 () {

        String title1 = searchResultsTitle.get(0).getText();
        String releasedDate1 = searchResultsReleaseDate.get(0).getText();
        String price1 = searchResultsPrice.get(0).getText();
        String reviews1 = searchResultsReviews.get(0).getAttribute("class");
        return title1 + releasedDate1 + price1 + reviews1;
    }

    public String gamesData2 () {
        String title2 = searchResultsTitle.get(1).getText();
        String releasedDate2 = searchResultsReleaseDate.get(1).getText();
        String price2 = searchResultsPrice.get(1).getText();
        String reviews2 = searchResultsReviews.get(1).getAttribute("class");
        return title2 + releasedDate2 + price2 + reviews2;
        }

//    public String platformsData1() {
//        for (WebElement platforms: searchResultsPlatforms1) {
//                return platforms.getAttribute("class");
//            }
//        return null;
//        }
}


