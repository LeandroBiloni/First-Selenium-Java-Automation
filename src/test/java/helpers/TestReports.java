package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReports {
    
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;
    private static ExtentReports extentReport;

    public static void initializeReporter(String docTitle) {
        if (extentReport != null){
            return;
        }
        
        extentReport = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\testReport");

        extentReport.attachReporter(sparkReporter);

        sparkReporter.config().setOfflineMode(true);
        sparkReporter.config().setDocumentTitle(docTitle);
        sparkReporter.config().setReportName("Test Report");
    }

    public static void createTest(String testName) {
        test = extentReport.createTest(testName);
    }

    public static void reportError(String text) {
        addMessage(Status.FAIL, text);
    }

    public static void reportSuccess(String text) {
        addMessage(Status.PASS, text);
    }

    public static void reportInfo(String text) {
        addMessage(Status.INFO, text);
    }
    private static void addMessage(Status messageType, String text) {
        test.log(messageType, text);
    }

    public static void flushReport() {
        extentReport.flush();
    }
}
