package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;

   // I'm using of concept of thread local : use of parallel execution
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // create method for set the browser
    // this method is used to initialze the thradLocal driver on the basic of given browser
    // @param browser
    // @return
    public WebDriver init_driver(String browser){
        System.out.println("browser value is: "+browser );

         if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else {
            System.out.println("Please pass the correct browser value: "+browser);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }
    // this is used to get the driver with Thread Local
    // @return
  public static synchronized WebDriver getDriver(){

        return tlDriver.get();
  }
}
