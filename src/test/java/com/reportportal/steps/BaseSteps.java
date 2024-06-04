//package com.reportportal.steps;
//
//import static com.codeborne.selenide.Selenide.open;
//
//import com.reportportal.config.ConfigProvider;
//import com.reportportal.pages.BasePage;
//import com.reportportal.pages.LoginPage;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import lombok.extern.slf4j.Slf4j;
//
//import static com.codeborne.selenide.Selenide.page;
//
//@Slf4j
// public class BaseSteps {
//
//  private final BasePage basePage = page(BasePage.class);
//  private final LoginPage loginPage = page(LoginPage.class);
//
//  @Given("Open report portal")
//  public void openRP() {
//    open(ConfigProvider.URL);
//    log.info("Logger added");
//  }
//
//  @When("Login to report portal")
//  public void putWord() {
//    loginPage.fillLoginField(ConfigProvider.LOGIN);
//    loginPage.fillPasswordField(ConfigProvider.PASSWORD);
//    loginPage.clickLoginButton();
//    basePage.isUserNameBlockVisible();
//
//  }
//}
