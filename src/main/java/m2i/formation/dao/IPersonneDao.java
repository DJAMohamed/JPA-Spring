package m2i.formation.dao;

import java.util.List;

import m2i.formation.model.Formateur;
import m2i.formation.model.Personne;
import m2i.formation.model.Stagiaire;

public interface IPersonneDao extends IDao<Personne, Long> {
	List<Personne> findAllByVille(String ville);
	
	List<Formateur> findAllFormateurByMatiere(String nom);
	
	//3
	List<Formateur> findAllFormateur();
	//4
	List<Stagiaire> findAllStagiaire();
	//5
	Formateur findByStagiaire(Long id);
	//6
	List<Stagiaire> findAllStagiaireByFormateur(Long id);
	//7
	List<Formateur> findAllFormateurExperienceGreaterThan(int experience);
}
