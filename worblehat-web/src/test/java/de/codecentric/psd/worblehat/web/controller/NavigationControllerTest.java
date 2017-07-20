package de.codecentric.psd.worblehat.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

public class NavigationControllerTest {

    @Test
    public void shouldNavigateToHome() throws Exception {
    	Model model = Mockito.mock(Model.class);
        String navigateTo = new NavigationController().home(model);

        assertThat(navigateTo, is("home"));
    }
}