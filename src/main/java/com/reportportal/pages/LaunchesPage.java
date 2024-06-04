package com.reportportal.pages;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchesPage {
  private final SelenideElement addFilterButton = $x("//*[contains(@class, 'add-filter-button')]");
  private final SelenideElement enterLaunchName = $x("//*[@placeholder='Enter name']");
  private final SelenideElement launchName = $x("//*[contains(@class, 'itemInfo__main-info')]");
  private final SelenideElement moreButton = $x("//*[contains(@class, 'entitiesSelector__toggler')]");
//  private final SelenideElement totalCheckbox = $x("//span[text()='Total']");
  private final SelenideElement totalCheckbox = $x("//*[contains(@class, 'inputCheckbox__input')]//span[text()='Total']");
  private final SelenideElement enterQuantity = $x("//*[contains(@placeholder, 'Enter quantity')] ");

//  private ElementsCollection totalQuantitiesForLaunches =
//      $$x("/  private ElementsCollection totalQuantitiesForLaunches =
//      $$x("//*[contains(@class, 'launchSuiteGrid__total')] ");;

  private ElementsCollection totalQuantitiesForLaunches =
      $$x("//*[contains(@class, 'executionStatistics__bold')]");

  private ElementsCollection launches =
      $$x("//*[contains(@class, 'launchSuiteGrid__name')]");


  public List<Integer> getTotalQuantitiesFoeLaunches(){
    launches.get(0).shouldBe(Condition.visible, Duration.ofSeconds(5));
    return totalQuantitiesForLaunches.texts().stream().map(Integer::parseInt).collect(Collectors.toList());
  }

  public void setQuantity(String quantity){
    enterQuantity.setValue(quantity);
  }

  public void clickOnMoreButton(){
    moreButton.click();
  }

  public void clickOnTotalCheckbox(){
    totalCheckbox.click();
  }

  public void clickAddFilterButton(){
    addFilterButton.click();
  }

  public void setLaunchName(String name){
    enterLaunchName.setValue(name);
  }

  public boolean verifyLaunchName(String name){
   return launchName.getText().toUpperCase().contains(name.toUpperCase());
  }


}
