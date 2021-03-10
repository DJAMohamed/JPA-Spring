package m2i.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "trainer")
public class Formateur extends Personne {
	@Temporal(TemporalType.DATE)
	@Column(name = "hiredate")
	private Date dtEmbauche;
	private int experience;
	@Column(name = "intern")
	private boolean interne;
	@OneToMany(mappedBy = "formateur", fetch = FetchType.LAZY)
	private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "skill", joinColumns = @JoinColumn(name = "trainer_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private List<Matiere> competences = new ArrayList<Matiere>();

	public Formateur() {
		super();
	}

	public Formateur(Civilite civilite, String nom, String prenom, String email, Date dtEmbauche, int experience,
			boolean interne) {
		super(civilite, nom, prenom, email);
		this.dtEmbauche = dtEmbauche;
		this.experience = experience;
		this.interne = interne;
	}

	public Formateur(Long id, Civilite civilite, String nom, String prenom, String email, Date dtEmbauche,
			int experience, boolean interne) {
		super(id, civilite, nom, prenom, email);
		this.dtEmbauche = dtEmbauche;
		this.experience = experience;
		this.interne = interne;
	}

	public Date getDtEmbauche() {
		return dtEmbauche;
	}

	public void setDtEmbauche(Date dtEmbauche) {
		this.dtEmbauche = dtEmbauche;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isInterne() {
		return interne;
	}

	public void setInterne(boolean interne) {
		this.interne = interne;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public List<Matiere> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Matiere> competences) {
		this.competences = competences;
	}

}
