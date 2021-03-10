package m2i.formation.dao;

import java.util.List;

import m2i.formation.model.Adresse;

public interface IAdresseDao extends IDao<Adresse, Long>{
	List<Adresse> findAllByVille(String ville);
	
	//1
	List<Adresse> findAllByCodePostal(String codePostal);
	//2
	List<Adresse> findAllByVilleOrCodePostal(String ville, String codePostal);
	//8
	Adresse findByPersonne(Long id); // piège
}
