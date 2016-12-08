package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by a576097 on 16/08/2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String nom;

    @Column
    private int puissance;

    @Column
    private String model;

    public String toString() {
        return "[" + "id : " + id + " nom : " + nom + "]";
    }

    public Car(String nom, int puissance, String model) {
        this.nom = nom;
        this.puissance = puissance;
        this.model = model;
    }
}
