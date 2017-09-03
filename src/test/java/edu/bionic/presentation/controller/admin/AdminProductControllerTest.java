package edu.bionic.presentation.controller.admin;

import edu.bionic.presentation.controller.BaseControllerTest;
import edu.bionic.testdata.UserFactory;
import org.junit.Test;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdminProductControllerTest extends BaseControllerTest {

    @Test
    @WithUserDetails("admin@mail.com")
    public void showProducts() throws Exception {
        mockMvc.perform(
                get("/admin/products")
//                .with(authenticatedWithUser(UserFactory.getAdmin()))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("admin/product-list"))
                .andExpect(model().attributeExists("products"));
    }

    @Test
    @WithUserDetails("user@mail.com")
    public void showProductsNotAdmin() throws Exception {
        mockMvc.perform(
                get("/admin/products")
//                        .with(authenticatedWithUser(UserFactory.getUser()))
        )
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void editProductPage() throws Exception {
    }

    @Test
    public void editProduct() throws Exception {
    }

    @Test
    public void newProductPage() throws Exception {
    }

    @Test
    public void editProduct1() throws Exception {
    }

    @Test
    public void deleteProduct() throws Exception {
    }

}