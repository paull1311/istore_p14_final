package edu.bionic.presentation.controller;

import edu.bionic.domain.Role;
import edu.bionic.testdata.UserFactory;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Collections;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class RootControllerTest extends BaseControllerTest {

    @Test
    public void showMainPage() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void loginPageUnauth() throws Exception {
        mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void loginPageAuthenticated() throws Exception {
        mockMvc.perform(
                get("/login")
                        .with(authenticatedWithUser(UserFactory.getUser()))
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void showRegisterPageUnauth() throws Exception {
        mockMvc.perform(get("/register"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    public void showRegisterPageAuthenticated() throws Exception {
        mockMvc.perform(
                get("/register")
                        .with(authenticatedWithUser(UserFactory.getUser()))
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void registerNewUser() throws Exception {
        mockMvc.perform(
                post("/register")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "newName")
                        .param("email", "valid@email.com")
                        .param("password", "newPassword")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(authenticated().withAuthorities(Collections.singleton(Role.USER)));
    }

    @Test
    public void registerNewUserNotEmail() throws Exception {
        mockMvc.perform(
                post("/register")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "newName")
                        .param("email", "not_valid_email.com")
                        .param("password", "newPassword")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("newUser"))
                .andExpect(model().attributeHasFieldErrors("newUser", "email"))
                .andExpect(unauthenticated());
    }

    @Test
    public void registerNewUserBlankFields() throws Exception {
        mockMvc.perform(
                post("/register")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "")
                        .param("email", "")
                        .param("password", "")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("newUser"))
                .andExpect(model().attributeHasFieldErrors("newUser", "email", "name", "password"))
                .andExpect(unauthenticated());
    }

}