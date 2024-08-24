package com.springboot.Savings.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.Savings.Enitity.Supplier;
import com.springboot.Savings.Enitity.SupplierSearchRequest;
import com.springboot.Savings.Service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@WebMvcTest(SupplierController.class)
public class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplierService supplierService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSearchSuppliers_Success() throws Exception {
        SupplierSearchRequest request = new SupplierSearchRequest("Israel", "Medium Scale", "3D Printing");
        Supplier supplier = new Supplier(9L, "S018", "PrathmeshIT Solution", "http://AnvitechSolutions.jp", "Israel", "Medium Scale", "3D Printing");
        List<Supplier> suppliers = Arrays.asList(supplier);

        when(supplierService.searchSuppliers(request)).thenReturn(suppliers);

        mockMvc.perform(post("/api/suppliers/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andDo(result -> System.out.println(result.getResponse().getContentAsString())) // Debugging line
                .andExpect(jsonPath("$[0].id").value(9))
                .andExpect(jsonPath("$[0].supplierId").value("S018"))
                .andExpect(jsonPath("$[0].companyName").value("PrathmeshIT Solution"))
                .andExpect(jsonPath("$[0].website").value("http://AnvitechSolutions.jp"))
                .andExpect(jsonPath("$[0].location").value("Israel"))
                .andExpect(jsonPath("$[0].natureOfBusiness").value("Medium Scale"))
                .andExpect(jsonPath("$[0].manufacturingProcess").value("3D Printing"));
    }


    @Test
    public void testSearchSuppliers_NoResults() throws Exception {
        SupplierSearchRequest request = new SupplierSearchRequest("NonExistentLocation", "NonExistentNature", "NonExistentProcess");
        List<Supplier> suppliers = Arrays.asList(); // Empty list

        when(supplierService.searchSuppliers(request)).thenReturn(suppliers);

        mockMvc.perform(post("/api/suppliers/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
