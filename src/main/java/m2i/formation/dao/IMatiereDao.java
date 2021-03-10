package m2i.formation.dao;

import java.util.List;

import m2i.formation.model.Difficulte;
import m2i.formation.model.Matiere;

public interface IMatiereDao extends IDao<Matiere, Long> {
	List<Matiere> findAllByDifficulte(Difficulte difficulte);
}
