package com.reportportal.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public class LoginPage {

  private SelenideElement loginField = $x("//*[@placeholder='Login']");
  private SelenideElement passwordField = $x("//*[@placeholder='Password']");
  private SelenideElement loginButton = $x("//*[@type='submit']");
  private SelenideElement messageContainer = $x("//*[contains(@class, 'notificationItem__message-container')]");
  private SelenideElement errorMessage = $x("//*[contains(@class, 'notificationItem__error')]");
  private SelenideElement successMessage = $x("//*[contains(@class, 'notificationItem__success')]");

  public boolean successMessageIsVisible(){
    messageContainer.shouldBe(Condition.enabled, Duration.ofSeconds(3));
    return successMessage.isDisplayed();
  }

  public boolean errorMessageIsVisible(){
    messageContainer.shouldBe(Condition.enabled, Duration.ofSeconds(3));
    return errorMessage.isDisplayed();
  }

  public void fillLoginField(String login){
    loginField.shouldBe(Condition.enabled, Duration.ofSeconds(30));
    loginField.setValue(login);
  }

  public void fillPasswordField(String password){
    passwordField.shouldBe(Condition.enabled, Duration.ofSeconds(30));
    passwordField.setValue(password);
  }

  public void clickLoginButton(){
    loginButton.click();
  }

}
