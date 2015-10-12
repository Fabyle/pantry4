package fr.fabien.taskmanagement.database;

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
	String etat;
	
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tache [idTache=");
		builder.append(idTache);
		builder.append(", label=");
		builder.append(label);
		builder.append(", etat=");
		builder.append(etat);
		builder.append("]");
		return builder.toString();
	}
	
    

}
