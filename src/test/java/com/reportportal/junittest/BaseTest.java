package com.reportportal.junittest;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.reportportal.config.ConfigProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public class BaseTest {

  @BeforeEach
  public void config(){
    Configuration.headless = true;
    open(ConfigProvider.URL);
    log.info("Browser is opened");
  }

  @AfterEach
  public void tearDown() {
    log.info("Browser is closed");
    Selenide.closeWindow();
    Selenide.closeWebDriver();
  }

}
