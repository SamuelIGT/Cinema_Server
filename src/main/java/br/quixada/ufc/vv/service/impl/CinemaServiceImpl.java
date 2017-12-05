package br.quixada.ufc.vv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.quixada.ufc.vv.bean.Cinema;
import br.quixada.ufc.vv.repository.CinemaRepository;
import br.quixada.ufc.vv.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinemaRp;

	private String verificaDuplicidade(Cinema cinema){
		for(Cinema cine : this.listarCinema()){
			if((cine.getNome().equals(cinema.getNome())) && (cine.getCidade().equals(cinema.getCidade()))){
				return "Cinema ja cadastrado";
			}
		}
		return "Cinema cadastrado com sucesso";
	}
	
	@Override
	public String criarCinema(Cinema cinema) {
		String verification = verificaDuplicidade(cinema);
		if(verification.equals("Cinema cadastrado com sucesso")){
			cinemaRp.save(cinema);
			return verification;
		}
		return verification;
	}

	@Override
	public void deletarCinema(Integer id) {
		cinemaRp.delete(id);
	}

	@Override
	public List<Cinema> listarCinema(){
		return cinemaRp.findAll();

	}

	@Override
	public String editarCinema(Cinema cinema) {
		String verification = verificaDuplicidade(cinema);
		if(!verification.equals("Cinema ja cadastrado")){
			cinemaRp.save(cinema);
			return verification;
		}
		
		return verification;
	}

	@Override
	public Cinema findCinemaById(Integer id){
		return cinemaRp.findOne(id);
	}

}
