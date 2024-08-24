package com.springboot.Savings.Enitity;

import jakarta.persistence.*;

@Entity
@Table(name = "manufacturing_process")
public class ManufacturingProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "process_name")
    private String processName;

    public ManufacturingProcess() {
    }

    public ManufacturingProcess(Long id, String processName) {
        this.id = id;
        this.processName = processName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
