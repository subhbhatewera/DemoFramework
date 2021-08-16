package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static String path = System.getProperty("user.dir");
	static ExtentReports extent ;
	
	public static ExtentReports getExtentReportObject() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(path+"/reports/index.html");
		reporter.config().setReportName("Demo Framework Development");
		reporter.getConf().setDocumentTitle("Demo Framework Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Subhash Bhatewera");
		return extent ;
	}

}
