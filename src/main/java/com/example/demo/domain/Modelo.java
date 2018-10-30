package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"fabricante"})
@Entity
public class Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idModelo;
	private String name;	
	private String ano;
	
	@ManyToOne
	@JoinColumn(name = "idFabricante")
	private Fabricante fabricante;

}
