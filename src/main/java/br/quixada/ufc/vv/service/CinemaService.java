package br.quixada.ufc.vv.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.quixada.ufc.vv.bean.Cinema;


public interface CinemaService{
	
	public String criarCinema(@RequestBody Cinema cinema);
	public void deletarCinema(@PathVariable Integer id);
	public List<Cinema> listarCinema();
	public Cinema findCinemaById(Integer id);
	public String editarCinema(@RequestBody Cinema cinema);

}
