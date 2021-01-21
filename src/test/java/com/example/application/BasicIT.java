package com.example.application;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.junit.Assert;
import org.junit.Test;

public class BasicIT {

    @Test
    public void enterName() throws Exception {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().withViewport(800, 600));
        Page page = context.newPage();

        page.navigate("http://localhost:8080/");
        page.type("vaadin-text-field[label='Your name']", "James Bond");
        page.click("vaadin-button");
        Assert.assertEquals("Hello James Bond", page.innerText("vaadin-notification-card"));

        browser.close();
        playwright.close();

    }
}
