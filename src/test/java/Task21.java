import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Year;


public class Task21 {
    private Data data = new Data();
    private WebDriverWait wait = new WebDriverWait(Singleton.driver(), Duration.ofSeconds(10));

    private String[] languagesList = {"english","spanish","french","german","italian","russian","japanese","portuguese","brazilian"};
    private String currentYear = String.valueOf(Year.now());


    @BeforeMethod
    public void setUpEnvironment () throws IOException, ParseException {
        Singleton.driver().navigate().to(data.config("url"));
    }

    @Test(priority = 1)
    public void privacyPolicy () throws IOException, ParseException {
        SteamPage steam = new SteamPage();

        steam.scrollToTheBottom();
        steam.openPrivacyPolicy();
        steam.switchTabs();

        PrivacyPolicy privacy = new PrivacyPolicy();

        wait.until(ExpectedConditions.titleIs(data.config("title")));
        Assert.assertEquals(privacy.titleOfPage(),data.config("title"), "Title is not correct");

        Assert.assertTrue(privacy.isSwitchLanguageDisplayed(),"Switch language elements list are not displayed");

        for (int i = 0; i < languagesList.length; i++)
        {
            Assert.assertEquals(privacy.areAllRequiredLanguagesDisplayed(i),  data.config("languageURL")+ languagesList[i] + "/", "Some supported language is missing");
        }

        Assert.assertTrue(privacy.policyRevisionSignedYear().contains(currentYear),"Policy revision is not signed in the current year. Current year: "+Year.now()+"\n"+privacy.policyRevisionSignedYear());
    }

    @Test(priority = 2)
    public void gameSearch () throws IOException, ParseException {
        SteamPage steam = new SteamPage();

        steam.searchGame(data.config("game"));

        SearchedGames products = new SearchedGames();

        Assert.assertEquals(products.titleOfPage(),data.config("Steam Search"), "Result page is not open");

        Assert.assertTrue(products.searchBar().contains(data.config("game")),"Search box on result page do not contains searched name");

        Assert.assertEquals(products.firstName(),data.config("game"),"First search result is not equal to searched name");

        String game2 = products.secondGame();  // need to save second game because getting Stale error!
        products.searchSecondGame();

        SecondResultsOfSearchedGames products2 = new SecondResultsOfSearchedGames();

        Assert.assertTrue(products2.searchBar().contains(game2),"Search box on result page does not contains searched name");

        Assert.assertTrue(products2.resultListOfGames().contains(data.config("game")) && products2.resultListOfGames().contains(game2),"Result list does not contains 2 stored items from the previous search");

        Assert.assertEquals(products2.gamesData1(),data.steamData1("Title")+data.steamData1("Release date")+data.steamData1("Price")+data.steamData1("Reviews"), "Stored data are not matched with actual data");

        Assert.assertEquals(products2.gamesData2(),data.steamData2("Title")+data.steamData2("Release date")+data.steamData2("Price")+data.steamData2("Reviews"), "Stored data are not matched with actual data");
    }

    @AfterTest
    public void after () {
        Singleton.driver().quit();
    }
}

