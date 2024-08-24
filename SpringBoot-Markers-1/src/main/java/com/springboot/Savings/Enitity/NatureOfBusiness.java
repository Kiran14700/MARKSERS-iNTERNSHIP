package com.springboot.Savings.Enitity;

import jakarta.persistence.*;

@Entity
@Table(name = "nature_of_business")
public class NatureOfBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nature_name")
    private String natureName;

    public NatureOfBusiness() {
    }

    public NatureOfBusiness(Long id, String natureName) {
        this.id = id;
        this.natureName = natureName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }
}
