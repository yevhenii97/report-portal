//package com.reportportal.testngtest;
//
//import static com.codeborne.selenide.Selenide.open;
//
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
//import com.reportportal.config.ConfigProvider;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class BaseTest {
//
//  @BeforeMethod
//  public void config(){
//    Configuration.headless = true;
//    open(ConfigProvider.URL);
//  }
//
//  @AfterMethod
//  public void tearDown() {
//    Selenide.closeWindow();
//    Selenide.closeWebDriver();
//  }
//}
