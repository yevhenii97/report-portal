package com.reportportal.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

  @Before
  public void config(){
    Configuration.headless = false;

  }

  @After
  public void tearDown() {
//    Selenide.closeWindow();
    Selenide.closeWebDriver();
  }
}
