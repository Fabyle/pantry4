/**
 * 
 */
package com.vaadin.tutorial.addressbook.backend;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author fabien
 *
 */
public class Tache implements Serializable, Cloneable {

	private Long id;

	private String label = "";
	private Date datePrevu;

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Tache clone() throws CloneNotSupportedException {
		try {
			return (Tache) BeanUtils.cloneBean(this);
		} catch (Exception ex) {
			throw new CloneNotSupportedException();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tache [id=" + id + ", label=" + label + ", datePrevu=" + datePrevu + "]";
	}

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param l
	 */
	public void setId(long l) {
		id = l;
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDatePrevu() {
		return datePrevu;
	}

	public void setDatePrevu(Date datePrevu) {
		this.datePrevu = datePrevu;
	}

}
