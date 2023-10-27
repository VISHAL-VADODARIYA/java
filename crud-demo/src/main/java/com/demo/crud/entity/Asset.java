package com.demo.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long assetId;

    private String assetName;

//    @ManyToMany(mappedBy = "assets")
//    private Set<Employee> employees = new HashSet<>();
}
