package com.example.springboottesting.controller;

import com.example.springboottesting.service.WelcomeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WelcomeControllerUnitTest {

    @Test
    public void shouldWelcome() {
        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        Mockito.when(welcomeService.getWelcomeMessage("Jon")).thenReturn("Welcome Jon!");
        WelcomeController welcomeController = new WelcomeController(welcomeService);
        Assertions.assertEquals("Welcome Jon!", welcomeController.welcome("Jon"));
    }
}
