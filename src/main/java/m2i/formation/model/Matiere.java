package m2i.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "subject")
@NamedQuery(name = "Matiere.findAllByDifficulte", query = "select m from Matiere m where m.difficulte = :dif")
public class Matiere {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "name", length = 100)
	private String nom;
	@Column(name = "duration")
	private int duree;
	@Column(name = "difficulty", length = 20)
	@Enumerated(EnumType.STRING)
	private Difficulte difficulte;
	@ManyToMany(mappedBy = "competences", fetch = FetchType.LAZY)
	private List<Formateur> formateurs = new ArrayList<Formateur>();

	public Matiere() {
		super();
	}

	public Matiere(String nom, int duree, Difficulte difficulte) {
		super();
		this.nom = nom;
		this.duree = duree;
		this.difficulte = difficulte;
	}

	public Matiere(Long id, String nom, int duree, Difficulte difficulte) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.difficulte = difficulte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

}
