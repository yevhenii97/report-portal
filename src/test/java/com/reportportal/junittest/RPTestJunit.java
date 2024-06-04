package com.reportportal.junittest;

import static com.codeborne.selenide.Selenide.page;

import com.reportportal.config.ConfigProvider;
import com.reportportal.pages.BasePage;
import com.reportportal.pages.LaunchesPage;
import com.reportportal.pages.LoginPage;
import java.util.Date;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@Slf4j
@Execution(ExecutionMode.CONCURRENT)
public class RPTestJunit extends BaseTest {

  private final BasePage basePage = page(BasePage.class);
  private final LoginPage loginPage = page(LoginPage.class);
  private final LaunchesPage launchesPage = page(LaunchesPage.class);


  @ParameterizedTest
  @CsvSource({
      "qwerty, qwerty, true, false",
      "Java, JAVA, true, false"
  })
  @MethodSource("provideTestData")
  @DisplayName("Check that log in is not successful")
  public void logIn(String logIn,
      String password,
      boolean isVisibleErrorMessage,
      boolean isVisibleSuccessMessage) {
    loginPage.fillLoginField(logIn);
    loginPage.fillPasswordField(password);
    loginPage.clickLoginButton();
    Assertions.assertEquals(isVisibleErrorMessage, loginPage.errorMessageIsVisible());
    Assertions.assertEquals(isVisibleSuccessMessage, loginPage.successMessageIsVisible());
    //
  }

  @ParameterizedTest
  @CsvSource({"test, true", "demo, true", "qwerty, false"})
  @DisplayName("Check that filter works as expected")
  public void verifyLaunchFilter(String launchName, boolean isFilterVisible) {
    loginPage.fillLoginField(ConfigProvider.LOGIN);
    loginPage.fillPasswordField(ConfigProvider.PASSWORD);
    loginPage.clickLoginButton();
    basePage.isUserNameBlockVisible();
    basePage.clickOnFiltersButton();
    basePage.openFilter();
    launchesPage.clickAddFilterButton();
    launchesPage.setLaunchName(launchName);
    Assertions.assertEquals(launchesPage.verifyLaunchName(launchName), isFilterVisible);
  }

  @ParameterizedTest
  @CsvSource({"17","20","22","25","30"})
  @DisplayName("Check that filter works as expected")
  public void verifyTotalFilter(int quantity) {
    loginPage.fillLoginField(ConfigProvider.LOGIN);
    loginPage.fillPasswordField(ConfigProvider.PASSWORD);
    loginPage.clickLoginButton();
    basePage.isUserNameBlockVisible();
    basePage.clickOnFiltersButton();
    basePage.openFilter();
    launchesPage.clickAddFilterButton();
    launchesPage.clickOnMoreButton();
    launchesPage.clickOnTotalCheckbox();
    launchesPage.setQuantity(String.valueOf(quantity));
    log.info("Total quantities: {}", launchesPage.getTotalQuantitiesFoeLaunches());
    launchesPage.getTotalQuantitiesFoeLaunches().forEach(qtt -> Assertions.assertTrue(qtt >= quantity));

  }

  private static Stream<Arguments> provideTestData() {
    return Stream.of(Arguments.of(ConfigProvider.LOGIN,ConfigProvider.PASSWORD, false, true));
  }

}
