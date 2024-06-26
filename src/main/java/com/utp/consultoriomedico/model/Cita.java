package com.utp.consultoriomedico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cita")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fecha_cita")
    private String fechaCita;
    @Column(name = "hora_cita")
    private String horaCita;
    @Column(name = "estado")
    private Boolean estado;
    
    @ManyToOne
    private Consultorio consultorio;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Especialidad especialidad;

}
