package DemoSeleniumFramework.PracticeProject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getExtentReportConfig() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		//extentsparkreporter,extentreport
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Framework");
		reporter.config().setDocumentTitle("Practice Test Report");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Surendra");
		return report;
	}
}
