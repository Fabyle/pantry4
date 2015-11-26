package fr.fabien.taskmanagement.database.business;

public class EtatTache {
	
	 String codeEtat;
     String labelEtat;
     
	public String getCodeEtat() {
		return codeEtat;
	}
	public void setCodeEtat(String codeEtat) {
		this.codeEtat = codeEtat;
	}
	public String getLabelEtat() {
		return labelEtat;
	}
	public void setLabelEtat(String libelleEtat) {
		this.labelEtat = libelleEtat;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EtatTache [codeEtat=");
		builder.append(codeEtat);
		builder.append(", libelleEtat=");
		builder.append(labelEtat);
		builder.append("]");
		return builder.toString();
	}
     
     

}
