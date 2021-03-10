package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IPersonneDao;
import m2i.formation.model.Civilite;
import m2i.formation.model.Formateur;
import m2i.formation.model.Personne;
import m2i.formation.model.Stagiaire;

@Repository
@Transactional(readOnly = true)
public class PersonneDaoJpa implements IPersonneDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Personne> findAll() {
		TypedQuery<Personne> query = em.createQuery("select p from Personne p", Personne.class);

		return query.getResultList();
	}

	@Override
	public Personne find(Long id) {
		return em.find(Personne.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Personne obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Personne update(Personne obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		Personne personne = em.find(Personne.class, id);
		em.remove(personne);
	}

	@Override
	public List<Personne> findAllByVille(String ville) {
		TypedQuery<Personne> query = em.createQuery("select p from Personne p where p.adresse.ville = :ville",
				Personne.class);

		query.setParameter("ville", ville);

		return query.getResultList();
	}

	@Override
	public List<Formateur> findAllFormateurByMatiere(String nom) {
		TypedQuery<Formateur> query = em
				.createQuery("select f from Formateur f left join f.competences c where c.nom = :nom", Formateur.class);

		query.setParameter("nom", nom);

		return query.getResultList();
	}

	public List<Personne> search(Civilite civilite, String nom, String prenom, String email) {
		List<Personne> personnes = new ArrayList<Personne>();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Personne> criteriaQuery = criteriaBuilder.createQuery(Personne.class);

		Root<Personne> root = criteriaQuery.from(Personne.class); // from Personne

		ParameterExpression<Civilite> civ = criteriaBuilder.parameter(Civilite.class);

		criteriaQuery.select(root); // select p from Personne p
		criteriaQuery.where(criteriaBuilder.equal(criteriaBuilder.literal(1), criteriaBuilder.literal(1)));

		if (civilite != null) {
			criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("civilite"), civ)));
		}

		return personnes;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		TypedQuery<Formateur> query = em.createQuery("select f from Formateur f", Formateur.class);

		return query.getResultList();
	}

	@Override
	public List<Stagiaire> findAllStagiaire() {
		TypedQuery<Stagiaire> query = em.createQuery("select s from Stagiaire s", Stagiaire.class);

		return query.getResultList();
	}

	@Override
	public Formateur findByStagiaire(Long id) {
//			TypedQuery<Formateur> query = em.createQuery("select f from Formateur f join f.stagiaires s where s.id = :id", Formateur.class);
//			TypedQuery<Formateur> query = em.createQuery("select f from Stagiaire s join s.formateur f where s.id = :id", Formateur.class);
		TypedQuery<Formateur> query = em.createQuery("select s.formateur from Stagiaire s where s.id = :id",
				Formateur.class);

		return query.getSingleResult();
	}

	@Override
	public List<Stagiaire> findAllStagiaireByFormateur(Long id) {
//			TypedQuery<Stagiaire> query = em.createQuery("select s from Formateur f join f.stagiaires s where f.id = :id", Stagiaire.class);
//			TypedQuery<Stagiaire> query = em.createQuery("select s from Stagiaire s where s.formateur.id = :id", Stagiaire.class);
		TypedQuery<Stagiaire> query = em.createQuery("select s from Stagiaire s join s.formateur f where f.id = :id",
				Stagiaire.class);

		query.setParameter("id", id);

		return query.getResultList();
	}

	@Override
	public List<Formateur> findAllFormateurExperienceGreaterThan(int experience) {
		TypedQuery<Formateur> query = em.createQuery("select f from Formateur f where f.experience = :experience",
				Formateur.class);

		query.setParameter("experience", experience);

		return query.getResultList();
	}

}
