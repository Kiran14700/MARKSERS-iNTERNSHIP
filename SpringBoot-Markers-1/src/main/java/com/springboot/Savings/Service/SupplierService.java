package com.springboot.Savings.Service;

import com.springboot.Savings.Enitity.Supplier;
import com.springboot.Savings.Enitity.SupplierSearchRequest;
import com.springboot.Savings.Exception.ResourceNotFoundException;
import com.springboot.Savings.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> searchSuppliers(SupplierSearchRequest searchRequest) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcess(
                searchRequest.getLocation(),
                searchRequest.getNatureOfBusiness(),
                searchRequest.getManufacturingProcess()
        );
    }
    
    

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    
    
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
    }

    
    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new ResourceNotFoundException("Supplier not found with id: " + id);
        }
        supplierRepository.deleteById(id);
    }
    
    
    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        
        existingSupplier.setSupplierId(updatedSupplier.getSupplierId());
        existingSupplier.setCompanyName(updatedSupplier.getCompanyName());
        existingSupplier.setWebsite(updatedSupplier.getWebsite());
        existingSupplier.setLocation(updatedSupplier.getLocation());
        existingSupplier.setNatureOfBusiness(updatedSupplier.getNatureOfBusiness());
        existingSupplier.setManufacturingProcess(updatedSupplier.getManufacturingProcess());

        return supplierRepository.save(existingSupplier);
    }
}
