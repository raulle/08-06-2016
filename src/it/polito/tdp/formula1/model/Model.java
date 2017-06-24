package it.polito.tdp.formula1.model;


import java.util.List;

import it.polito.tdp.formula1.db.F1DAO;

public class Model {
	
	private F1DAO dao;
	
	public Model(){
		this.dao= new F1DAO();
	}
	
	public List<Season> getStagioni(){
		return dao.getAllSeasons();
	}
	
	public List<Circuit> getCircuiti(int anno){
		return dao.getCicuiti(anno);
	}
	
	public Race getRace(int anno, int idCir){
		return dao.getRace(anno, idCir);
	}
	
	public List<Driver> getPiloti(int idRace){
		return dao.getPiloti(idRace);
	}


}
