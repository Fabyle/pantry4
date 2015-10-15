package fr.fabien.taskmanagement.database.business;

import java.util.Date;

/**
 * TODO ajouter un commentaire
 * 
 * @author Systalians - lemoinef
 * @date $Date$
 * @version $Revision$
 */
public class Tache {
	
	
	String idTache;
	String label;
	String _basicEtat;
	EtatTache etatTache;
	Date dateEtat;
	Date dateCreation;
	
	
	public String getIdTache() {
		return idTache;
	}
	public void setIdTache(String idTache) {
		this.idTache = idTache;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String get_BasicEtat() {
		return _basicEtat;
	}
	public void set_BasicEtat(String etat) {
		this._basicEtat = etat;
	}
	public EtatTache getEtatTache() {
		return etatTache;
	}
	public void setEtatTache(EtatTache etatTache) {
		this.etatTache = etatTache;
	}
	
	public Date getDateEtat() {
		return dateEtat;
	}
	public void setDateEtat(Date dateEtat) {
		this.dateEtat = dateEtat;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tache [idTache=");
		builder.append(idTache);
		builder.append(", label=");
		builder.append(label);
		builder.append(", _basicEtat=");
		builder.append(_basicEtat);
		builder.append(", etatTache=");
		builder.append(etatTache);
		builder.append(", dateEtat=");
		builder.append(dateEtat);
		builder.append(", dateCreation=");
		builder.append(dateCreation);
		builder.append("]");
		return builder.toString();
	}
	
	
	
    

}
