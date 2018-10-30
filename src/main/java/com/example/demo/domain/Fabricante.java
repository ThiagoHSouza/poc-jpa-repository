package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFabricante;
	private String name;
	
	@OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Modelo> modelos;

}
