import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Singleton {

    private static WebDriver driver;

    public static WebDriver driver() {
        if (driver==null)
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--lang=en-GB");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
}