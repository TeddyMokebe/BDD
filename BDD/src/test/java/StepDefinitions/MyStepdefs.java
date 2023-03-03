package StepDefinitions;

import Driver.driverInitialization;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyStepdefs extends driverInitialization {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test1;

    public String orderNum;

    @Given("a user is on the home page")
    public void aUserIsOnTheHomePage() {
        driver = initializeDriver();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Teddy.Mokebe\\IdeaProjects\\BDD\\BDD\\Report4\\report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        test1 = extent.createTest("login").assignAuthor("Tester1").assignCategory("Smoke test").assignDevice("Chrome").addScreenCaptureFromPath("Screenshot.png");
        test1.log(Status.PASS, "User Fills in Login credentials");
        test1.pass("User successfully logged in");
//        test1.fail("login", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
//        test1.addScreenCaptureFromPath("screenshot.png");



    }

    @When("a user navigates to the Login page using {string}")
    public void aUserNavigatesToTheLoginPageUsing(String sURL) {
        driver.get(sURL);
    }

    @And("a user enter {string} and {string}")
    public void aUserEnterUsernameAndPassword(String sUsername, String sPassword) {
        driver.findElement(By.id("username")).sendKeys(sUsername);
        driver.findElement(By.id("password")).sendKeys(sPassword);
    }

    @And("a user clicks the login button")
    public void aUserClicksTheLoginButton() {
        driver.findElement(By.id("login")).click();
    }

    @Then("a user is logged in successfully")
    public void aUserIsLoggedInSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        if (!driver.findElement(By.id("location")).isDisplayed()){
            test1.assignDevice("Mac");
        test1.assignAuthor("Tester1");
        test1.fail("Login unsuccessful");
        Assert.fail();

        } else{
            test1.assignDevice("Mac");
            test1.assignAuthor("Tester1");
            test1.pass("Login successful");


        }



        extent.flush();
    }


//    @Given("user is on book a hotel page")
//    public void userIsOnBookAHotelPage() {
//
//
//    }

    @When("user searches for the desired hotel")
    public void userSearchesForTheDesiredHotel() {

        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Teddy.Mokebe\\IdeaProjects\\BDD\\BDD\\Report4\\report.html");
        test1 = extent.createTest("BookHotel").assignAuthor("Tester2").assignCategory("Stress test").assignDevice("Chrome");
        test1.info("Desired hotel search displaying");
        test1.pass("User successfully booked hotel");

        WebElement staticDropdown = driver.findElement(By.id("location"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        WebElement staticDropdown1 = driver.findElement(By.id("hotels"));
        Select dropdown1 = new Select(staticDropdown1);
        dropdown1.selectByIndex(3);
        System.out.println(dropdown1.getFirstSelectedOption().getText());

        WebElement staticDropdown2 = driver.findElement(By.id("room_type"));
        Select dropdown2 = new Select(staticDropdown2);
        dropdown2.selectByIndex(2);
        System.out.println(dropdown2.getFirstSelectedOption().getText());


        WebElement staticDropdown3 = driver.findElement(By.id("room_nos"));
        Select dropdown3 = new Select(staticDropdown1);
        dropdown3.selectByIndex(2);
        System.out.println(dropdown3.getFirstSelectedOption().getText());


        WebElement staticDropdown4 = driver.findElement(By.id("adult_room"));
        Select dropdown4 = new Select(staticDropdown4);
        dropdown4.selectByIndex(3);
        System.out.println(dropdown4.getFirstSelectedOption().getText());

        WebElement staticDropdown5 = driver.findElement(By.id("child_room"));
        Select dropdown5 = new Select(staticDropdown5);
        dropdown5.selectByIndex(2);
        System.out.println(dropdown5.getFirstSelectedOption().getText());

        driver.findElement(By.name("Submit")).click();
        driver.findElement(By.name("radiobutton_0")).click();
        driver.findElement(By.name("continue")).click();
    }

    @And("user enter {string} , {string} , {string}, {string} , {string},  {string}")

    public void userEnter(String parFirstname, String parLastname, String parBill, String parCard_no, String parCard_card, String parCvv) throws InterruptedException {
        driver.findElement(By.id("first_name")).sendKeys(parFirstname);
        driver.findElement(By.id("last_name")).sendKeys(parLastname);
        driver.findElement(By.id("address")).sendKeys(parBill);
        driver.findElement(By.id("cc_num")).sendKeys(parCard_no);
        driver.findElement(By.id("cc_type")).sendKeys(parCard_card);

        WebElement staticDropdown7 = driver.findElement(By.id("cc_exp_month"));
        Select dropdown7 = new Select(staticDropdown7);
        dropdown7.selectByIndex(2);
        System.out.println(dropdown7.getFirstSelectedOption().getText());

        WebElement staticDropdown8 = driver.findElement(By.id("cc_exp_year"));
        Select dropdown8 = new Select(staticDropdown8);
        dropdown8.selectByIndex(2);
        System.out.println(dropdown8.getFirstSelectedOption().getText());
        driver.findElement(By.id("cc_cvv")).sendKeys(parCvv);
        driver.findElement(By.name("book_now")).click();
        Thread.sleep(5000);
    }

    @Then("hotel booked successfully")
    public void hotelBookedSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        if (!driver.findElement(By.id("order_no")).isDisplayed()) {
            test1.assignDevice("Samsung s21");
            test1.assignAuthor("Tester2");
            test1.fail("booking unsuccessful");
            Assert.fail();

        } else {
            test1.assignDevice("Mac");
            test1.assignAuthor("Tester2");
            test1.pass("Login successful");


        }
        extent.flush();

        }




    @Then("hotel booked unsuccessfully")
    public void hotelBookedUnsuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        if (driver.findElement(By.id("location")).isDisplayed()){
            test1.assignDevice("Mac");
            test1.assignAuthor("Tester1");
            test1.fail("Login unsuccessful");
            Assert.fail();

        } else{
            test1.assignDevice("Mac");
            test1.assignAuthor("Tester1");
            test1.pass("Login successful");


        }
//        extent.flush();

    }

    @And("a user copies the order number and paste it on the search hotel")
    public void aUserCopiesTheOrderNumberAndPasteItOnTheSearchHotel() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        orderNum = driver.findElement(By.id("order_no")).getAttribute("value");
        driver.findElement(By.id("my_itinerary")).click();
        driver.findElement(By.id("order_id_text")).sendKeys(orderNum);
        Thread.sleep(2000);


    }

    @And("a user clicks on Go for search")
    public void aUserClicksOnGoForSearch() {

        driver.findElement(By.id("search_hotel_id")).click();
    }

    @Then("the hotel search with order number is successful")
    public void theHotelSearchWithOrderNumberIsSuccessful() {
        if (!driver.findElement(By.id("search_result_error")).isDisplayed())
        {
            test1.assignDevice("HP");
            test1.assignAuthor("Tester3");
            test1.fail("search with number unsuccessful");
            Assert.fail();

        } else {
            test1.assignDevice("Mac");
            test1.assignAuthor("Tester1");
            test1.pass("search with number successful");


        }


        driver.findElement(By.id("logout")).click();

    }
    public static String capturescreenshot(WebDriver driver) throws IOException {
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationfilepath = new File("C:\\Users\\Teddy.Mokebe\\IdeaProjects\\BDD\\BDD\\Report2\\Image\\screenshot.png");

        String absolutepathlocation = destinationfilepath.getAbsolutePath();

        FileUtils.copyFile(srcfile ,destinationfilepath);
        return absolutepathlocation;}


}
