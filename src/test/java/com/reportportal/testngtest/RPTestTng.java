//package com.reportportal.testngtest;
//
//import static com.codeborne.selenide.Selenide.page;
//
//import com.reportportal.config.ConfigProvider;
//import com.reportportal.pages.BasePage;
//import com.reportportal.pages.LaunchesPage;
//import com.reportportal.pages.LoginPage;
//import java.util.Date;
//import lombok.extern.slf4j.Slf4j;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//@Slf4j
//@Test(threadPoolSize = 4, invocationCount = 4, timeOut = 1000)
//public class RPTestTng extends BaseTest {
//
//  private final BasePage basePage = page(BasePage.class);
//  private final LoginPage loginPage = page(LoginPage.class);
//  private final LaunchesPage launchesPage = page(LaunchesPage.class);
//
//  @Test(description = "Check that log in is successful", dataProvider = "logInData")
//  public void logIn(String logIn,
//      String password,
//      boolean isVisibleErrorMessage,
//      boolean isVisibleSuccessMessage) {
//    loginPage.fillLoginField(logIn);
//    loginPage.fillPasswordField(password);
//    loginPage.clickLoginButton();
//    log.info("CurrentThread id: {}",Thread.currentThread().getId());
//    log.info("Time: {}", new Date(System.currentTimeMillis()));
//    Assert.assertEquals(isVisibleErrorMessage, loginPage.errorMessageIsVisible());
//    Assert.assertEquals(isVisibleSuccessMessage, loginPage.successMessageIsVisible());
//  }
//
//  @Test(description = "Check that", dataProvider = "launchName")
//  public void verifyLaunchFilter(String launchName, boolean isFilterVisible) {
//    loginPage.fillLoginField(ConfigProvider.LOGIN);
//    loginPage.fillPasswordField(ConfigProvider.PASSWORD);
//    loginPage.clickLoginButton();
//    basePage.isUserNameBlockVisible();
//    basePage.clickOnFiltersButton();
//    basePage.openFilter();
//    launchesPage.clickAddFilterButton();
//    launchesPage.setLaunchName(launchName);
//    Assert.assertEquals(launchesPage.verifyLaunchName(launchName), isFilterVisible);
//  }
//
//  @Test(description = "Check that total filter works as expected", dataProvider = "quantities")
//  public void verifyTotalFilter(int quantity) {
//    loginPage.fillLoginField(ConfigProvider.LOGIN);
//    loginPage.fillPasswordField(ConfigProvider.PASSWORD);
//    loginPage.clickLoginButton();
//    basePage.isUserNameBlockVisible();
//    basePage.clickOnFiltersButton();
//    basePage.openFilter();
//    launchesPage.clickAddFilterButton();
//    launchesPage.clickOnMoreButton();
//    launchesPage.clickOnTotalCheckbox();
//    launchesPage.setQuantity(String.valueOf(quantity));
//    log.info("Total quantities: {}", launchesPage.getTotalQuantitiesFoeLaunches());
//    launchesPage.getTotalQuantitiesFoeLaunches().forEach(qtt -> Assert.assertTrue(qtt >= quantity));
//  }
//
//  @DataProvider(name = "logInData", parallel = true)
//  public Object[][] logInData() {
//    return new Object[][]{
//        {ConfigProvider.LOGIN, ConfigProvider.PASSWORD, false, true},
//        {"qwerty", ConfigProvider.PASSWORD, true, false},
//        {ConfigProvider.LOGIN, "qwerty", true, false},
//        {"login", "pswrd", true, false}
//    };
//  }
//
//  @DataProvider(name = "launchName", parallel = true)
//  public Object[][] launchNameData() {
//    return new Object[][]{
//        {"test", true},
//        {"demo", true},
//        {"qwerty", false}
//    };
//  }
//
//  @DataProvider(name = "quantities")
//  public Object[][] quantities() {
//    return new Object[][]{
//        {17},
//        {20},
//        {22},
//        {25},
//        {30},
//    };
//
//  }
//  }
