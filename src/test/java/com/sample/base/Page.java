package com.sample.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class Page {

    protected final WebDriverWrapper wrapper;

    public Page(WebDriverWrapper wrapper) {
        this.wrapper = wrapper;
    }

    protected void shouldBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(wrapper.driver, Timeout.DEFAULT_SECONDS);
        WebElement refreshedElement = wait.until(refreshed(visibilityOf(element)));
        assertThat(refreshedElement.isDisplayed(), equalTo(true));
    }

    protected void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(wrapper.driver, Timeout.DEFAULT_SECONDS);
        WebElement refreshedElement = wait.until(refreshed(elementToBeClickable(element)));
        refreshedElement.click();
    }
}
