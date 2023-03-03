package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"C:\\Users\\Teddy.Mokebe\\IdeaProjects\\BDD\\BDD\\src\\test\\java\\Features\\BookHotel.feature"},
        glue = {"StepDefinition"},

        plugin = {"pretty","html:target/cucumber1.html"}

)


public class TestRunner {

//    @AfterClass
//    public void aftertest(){
//
//        // Create a constant method
//
//    }
}
