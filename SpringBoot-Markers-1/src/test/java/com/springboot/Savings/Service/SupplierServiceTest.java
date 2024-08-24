package com.springboot.Savings.Service;

import com.springboot.Savings.Enitity.Supplier;
import com.springboot.Savings.Enitity.SupplierSearchRequest;
import com.springboot.Savings.Repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class SupplierServiceTest {

    @InjectMocks
    private SupplierService supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchSuppliers_Success() {
        SupplierSearchRequest request = new SupplierSearchRequest("Israel", "Medium Scale", "3D Printing");
        
        Supplier supplier1 = new Supplier(18L, "S018", "PrathmeshIT Solution", "http://AnvitechSolutions.jp", "Israel", "Medium Scale", "3D Printing");
        List<Supplier> suppliers = Arrays.asList(supplier1);

        when(supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcess(
                request.getLocation(), request.getNatureOfBusiness(), request.getManufacturingProcess()))
            .thenReturn(suppliers);

        List<Supplier> result = supplierService.searchSuppliers(request);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("S018", result.get(0).getSupplierId());
        assertEquals("PrathmeshIT Solution", result.get(0).getCompanyName());
        assertEquals("http://AnvitechSolutions.jp", result.get(0).getWebsite());
        assertEquals("Israel", result.get(0).getLocation());
        assertEquals("Medium Scale", result.get(0).getNatureOfBusiness());
        assertEquals("3D Printing", result.get(0).getManufacturingProcess());
    }
}
