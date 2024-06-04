package com.reportportal.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public class BasePage {

  private final SelenideElement userNameBlock = $x("//*[contains(@class, 'userBlock__username')]");
  private final SelenideElement filtersButton = $x("//*[contains(@href, 'filters')]");
  private final SelenideElement filterName = $x("//*[contains(@class, 'filterName__bold')]");

  public void isUserNameBlockVisible() {
    userNameBlock.shouldBe(Condition.visible, Duration.ofSeconds(10));
  }

  public boolean checkThatUserNameBlockIsVisible() {
    userNameBlock.shouldBe(Condition.visible, Duration.ofSeconds(5));
    return userNameBlock.is(Condition.visible);
  }

  public void clickOnFiltersButton() {
    filtersButton.click();
  }

  public void openFilter() {
    filterName.click();
  }

  public String getFilterName() {
    return filterName.getText();
  }

}
