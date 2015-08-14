package com.bmo.common;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;

public class GalenReportingListener implements IReporter {

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> iSuites, String s) {
        System.out.println("Generating Galen Html reports");
        List<GalenTestInfo> tests = GalenReportsContainer.get().getAllTests();

        try {
            new HtmlReportBuilder().build(tests, "target/galen-html-reports");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
