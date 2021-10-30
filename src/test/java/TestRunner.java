import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
            features = "src/test/resources/features",
            glue = "com.product.test.steps")

    public class TestRunner {
    }

