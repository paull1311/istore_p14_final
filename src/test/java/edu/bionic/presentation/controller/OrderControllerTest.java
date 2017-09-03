package edu.bionic.presentation.controller;

import edu.bionic.testdata.UserFactory;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Volodymyr Portianko
 * @since 23.08.2017
 */
public class OrderControllerTest extends BaseControllerTest {


    @Test
    public void showOrdersForUser() throws Exception {
        mockMvc.perform(
                get("/orders")
                        .with(authenticatedWithUser(UserFactory.getUser()))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("order/order-list"))
                .andExpect(model().attributeExists("orders"));
    }

    @Test
    public void showOrdersForUserUnauthenticated() throws Exception {
        mockMvc.perform(
                get("/orders")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    public void showNewOrderPage() throws Exception {
    }

    @Test
    public void submitNewOrder() throws Exception {
    }

    @Test
    public void removeItemFromOrder() throws Exception {
    }

    @Test
    public void successCreatedOrderPage() throws Exception {
    }

}