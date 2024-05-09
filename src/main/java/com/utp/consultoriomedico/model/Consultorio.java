package com.utp.consultoriomedico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultorio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numero_consultorio")
    private String numeroConsultorio;
    @Column(name = "piso")
    private String piso;
    @Column(name = "ala")
    private String ala;

}
