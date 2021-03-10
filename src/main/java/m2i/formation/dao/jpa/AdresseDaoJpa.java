package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.model.Adresse;

@Repository
@Transactional(readOnly = true)
public class AdresseDaoJpa implements IAdresseDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Adresse> findAll() {
		TypedQuery<Adresse> query = em.createQuery("select adr from Adresse adr", Adresse.class);

		return query.getResultList();
	}

	@Override
	public Adresse find(Long id) {
		return em.find(Adresse.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Adresse obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Adresse update(Adresse obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {

		Adresse adresse = em.find(Adresse.class, id);
		em.remove(adresse);
	}

	@Override
	public List<Adresse> findAllByVille(String ville) {
		TypedQuery<Adresse> query = em.createQuery("select adr from Adresse adr where adr.ville = :maVille",
				Adresse.class);

		query.setParameter("maVille", ville);

		return query.getResultList();
	}

	@Override
	public List<Adresse> findAllByCodePostal(String codePostal) {
		TypedQuery<Adresse> query = em.createQuery("select adr from Adresse adr where adr.codePostal = :cp",
				Adresse.class);

		query.setParameter("cp", codePostal);

		return query.getResultList();
	}

	@Override
	public List<Adresse> findAllByVilleOrCodePostal(String ville, String codePostal) {
		TypedQuery<Adresse> query = em.createQuery(
				"select adr from Adresse adr where adr.ville = :ville or adr.codePostal = :cp", Adresse.class);

		query.setParameter("ville", ville);
		query.setParameter("cp", codePostal);

		return query.getResultList();
	}

	@Override
	public Adresse findByPersonne(Long id) {
		TypedQuery<Adresse> query = em.createQuery("select p.adresse from Personne p where p.id = :id", Adresse.class);

		query.setParameter("id", id);

		return query.getSingleResult();
	}

}
