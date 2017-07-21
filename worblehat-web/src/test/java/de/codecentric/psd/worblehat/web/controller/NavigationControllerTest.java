package de.codecentric.psd.worblehat.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.ui.ModelMap;

public class NavigationControllerTest {

    @Test
    public void shouldNavigateToHome() throws Exception {
    	ModelMap model = new ModelMap();
        String navigateTo = new NavigationController().home(model);

        assertThat(navigateTo, is("home"));
    }
}