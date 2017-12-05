package br.quixada.ufc.vv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.quixada.ufc.vv.bean.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
	
	public Cinema findById(Integer id);
}
