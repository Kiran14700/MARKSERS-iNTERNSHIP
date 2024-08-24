package com.springboot.Savings.Repository;

import com.springboot.Savings.Enitity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.natureOfBusiness IN :natureOfBusiness AND s.manufacturingProcess IN :manufacturingProcesses")
    List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcess(
            @Param("location") String location,
            @Param("natureOfBusiness") String natureOfBusiness,
            @Param("manufacturingProcesses") String manufacturingProcesses);
}
