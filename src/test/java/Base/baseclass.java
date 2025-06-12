package Base;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.lang.reflect.Method;

import Commons.APIHelper;
import Commons.ConfigReader;
import io.restassured.RestAssured;

@Listeners(ChainTestListener.class)
public class baseclass {
	
	protected static ExtentReports extent;
    protected static ExtentTest test;
	

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester", "Your Name");
    }
    
//    @BeforeMethod
//    // Heroapp 503 issue workaround fix
//    public void warmUpApp() {
//        try {
//            System.out.println("Warming up Heroku app before state-changing test...");
//            RestAssured.get("https://userserviceapp-f5a54828541b.herokuapp.com/uap/users/health");
//            Thread.sleep(5000); // Wait for dyno to fully wake up
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        } catch (Exception ex) {
//            System.err.println("Failed to warm up app: " + ex.getMessage());
//        }
//    }

    
	@BeforeClass
    public void setUp() throws IOException {
		ConfigReader config = new ConfigReader();
		APIHelper api = new APIHelper();
		api.setbaseurl(config.getbaseurl());
		api.setusername(config.getusername());
		api.setpassword(config.getpassword());
    }
	
	 @AfterSuite
	    public void tearDownReport() {
	        extent.flush();
	    }
	 
	 @BeforeMethod
	 public void createTest(Method method) {
	        test = extent.createTest(method.getName());
	    }
	 
}
