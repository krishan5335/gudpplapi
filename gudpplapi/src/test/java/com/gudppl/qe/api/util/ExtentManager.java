package com.gudppl.qe.api.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static String OS = null;
    private static String reportFileName = "API-Test-Automaton-Report.html";
    private static String windowsPath = System.getProperty("user.dir") + "\\TestReport";
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;
    private static String ubuntuPath = "./TestReport";
    private static String ubuntuReportFileLoc = ubuntuPath + "/" + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportFileLocation();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("UI-Test-Automaton-Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }


    public static String getOsName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    //Select the extent report file location based on platform
    private static String getReportFileLocation() {
        String reportFileLocation = null;
        if (isWindows()) {
            reportFileLocation = winReportFileLoc;
            System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
            createReportPath(windowsPath);
        } else {
            reportFileLocation = ubuntuReportFileLoc;
            System.out.println("ExtentReport Path for Ubuntu: " + ubuntuReportFileLoc + "\n" + "ubuntuPath:" + ubuntuPath + "\n");
            createReportPath(ubuntuPath);
        }

        return reportFileLocation;
    }

    //Create the report path if it does not exist
    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                // LoggerUtil.log("Directory: " + path + " is created!");
            } else {
                // LoggerUtil.log("Failed to create directory: " + path);
            }
        } else {
            // LoggerUtil.log("Directory already exists: " + path);
        }
    }


}
