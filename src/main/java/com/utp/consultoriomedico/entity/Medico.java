package com.utp.consultoriomedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private String dni;
    private String fechaNacimiento;
    private String sexo;
    private String estadoCivil;
    @ManyToOne
    private Especialidad especialidad;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Consultorio consultorio;
    @ManyToOne
    private Horario horario;

    
    
}
