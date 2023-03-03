package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CreativeReport {
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Teddy.Mokebe\\IdeaProjects\\BDD\\BDD\\Reports\\Report1.html");


    @Test
public void f1(){
        ExtentTest test = extent.createTest("Login").assignAuthor("Teddy").assignCategory("Smoke test").assignDevice("Chrome");
        test.log(Status.PASS, "User Fills in Login credentials");
        test.pass("User successfully logged in");

}
    @Test
    public void f2(){
        ExtentTest test = extent.createTest("Book Hotel Successfully").assignAuthor("Tester1").assignCategory("Stress test").assignDevice("Mac");
        test.info("Desired hotel search displaying");
        test.pass("User successfully booked hotel");

    }    @Test
    public void f3(){
        ExtentTest test = extent.createTest("Book Hotel unsuccessfully").assignAuthor("Tester2").assignCategory("Smoke test").assignDevice("Edge");
        test.info("Desired hotel search displaying");
        test.fail("User could not book hotel");
    }    @Test
    public void f4(){
        ExtentTest test = extent.createTest("Search itinerary by order number").assignAuthor("Tester3").assignCategory("Smoke test").assignDevice("Safari");
        test.info("Use order number to see itinerary");
        test.pass("successful outcome");
    }
@BeforeTest
    public void beforeTest(){

    extent.attachReporter(spark);
    spark.config().setTheme(Theme.DARK);
    spark.config().setDocumentTitle("MyReport");
}
@AfterTest
    public void afterTest(){

        extent.flush();
}
//@Test
//public void f5(){
//    ExtentTest test = extent.createTest("Login").assignAuthor("Teddy").assignCategory("Smoke test").assignDevice("Chrome");
//
//}
public static String capturescreenshot(WebDriver driver) throws IOException {
    File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File destinationfilepath = new File("C:\\Users\\Teddy.Mokebe\\IdeaProjects\\BDD\\BDD\\Reports\\images\\screenshot"+System.currentTimeMillis()+".png");

    String absolutepathlocation = destinationfilepath.getAbsolutePath();

    FileUtils.copyFile(srcfile ,destinationfilepath);
    return absolutepathlocation;
}
}
