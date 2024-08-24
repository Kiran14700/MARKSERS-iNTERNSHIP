package com.springboot.Savings.Controller;

import com.springboot.Savings.Enitity.Supplier;
import com.springboot.Savings.Enitity.SupplierSearchRequest;
import com.springboot.Savings.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Search
    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> searchSuppliers(@RequestBody SupplierSearchRequest searchRequest) {
        List<Supplier> suppliers = supplierService.searchSuppliers(searchRequest);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    }
}

//posting data

//{"supplierId": "S018",
//    "companyName": "PrathmeshIT Solution",
//    "website": "http://AnvitechSolutions.jp",
//    "location": "Israel",
//    "natureOfBusiness": "Medium Scale",
//    "manufacturingProcess": "3D Printing"
//}
