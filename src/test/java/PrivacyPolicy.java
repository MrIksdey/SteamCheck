import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PrivacyPolicy {
    private WebElement languages = Singleton.driver().findElement(By.id("languages"));
    private List<WebElement> listOfElements = Singleton.driver().findElements(By.xpath("//*[@id='languages']//a"));

    public String titleOfPage ()
    {
        String title = Singleton.driver().getTitle();
        return title;
    }

    public boolean isSwitchLanguageDisplayed()
    {
        boolean switchLanguage = languages.isDisplayed();
        return switchLanguage;
    }


    public String areAllRequiredLanguagesDisplayed(int i) {
            String eachElement = listOfElements.get(i).getAttribute("href");
            return eachElement;
    }


    public String policyRevisionSignedYear()
    {
        String revisionYear = Singleton.driver().findElement(By.xpath("//*[contains(text(),'Revision Date')]")).getText();
        return revisionYear;
    }
}
