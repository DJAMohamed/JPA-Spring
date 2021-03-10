package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IMatiereDao;
import m2i.formation.model.Difficulte;
import m2i.formation.model.Matiere;

@Repository
@Transactional(readOnly = true)
public class MatiereDaoJpa implements IMatiereDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Matiere> findAll() {
		TypedQuery<Matiere> query = em.createQuery("select m from Matiere m", Matiere.class);

		return query.getResultList();
	}

	@Override
	public Matiere find(Long id) {
		return em.find(Matiere.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Matiere obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Matiere update(Matiere obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		Matiere matiere = em.find(Matiere.class, id);
		em.remove(matiere);
	}

	@Override
	public List<Matiere> findAllByDifficulte(Difficulte difficulte) {
		TypedQuery<Matiere> query = em.createNamedQuery("Matiere.findAllByDifficulte", Matiere.class);
		query.setParameter("dif", difficulte);

		return query.getResultList();
	}

}
