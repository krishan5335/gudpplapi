package com.gudppl.qe.api.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.gudppl.qe.api.util.ExtentManager;
import com.gudppl.qe.api.util.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

public class TestListener extends TestBase implements ITestListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onStart(ITestContext context) {
        // LoggerUtil.log("Extent Reports Version 3 Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        // LoggerUtil.log(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        //  LoggerUtil.log((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        //  LoggerUtil.log((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        //  LoggerUtil.log((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());

    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        // LoggerUtil.log((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //  LoggerUtil.log(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

    @AfterSuite
    public void tearDown(){
        extent.flush();
    }


}
