package com.example.demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
	
	public Fabricante findByName(String name);
	public List<Fabricante> findByModelosAno(String ano);

}
