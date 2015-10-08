package com.vaadin.tutorial.addressbook.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author fabien
 *
 */


public class TacheService {

	/** Constructeur privé */
	private TacheService() {
	}

	/** Holder */
	private static class TacheServiceHolder {
		/** Instance unique non préinitialisée */
		private final static TacheService instance = new TacheService();
	}

	/** Point d'accès pour l'instance unique du singleton */
	public static TacheService getInstance() {
		return TacheServiceHolder.instance;
	}

	private HashMap<Long, Tache> taches = new HashMap<>();
	private long nextId = 0;

	
	/**
	 * @param stringFilter
	 * @return la liste des taches vérifiant les criteres
	 */
	public synchronized List<Tache> findAll(String stringFilter) {
		ArrayList<Tache> arrayList = new ArrayList<Tache>();
		for (Tache tache : taches.values()) {
			try {
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
						|| tache.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					arrayList.add(tache.clone());
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, new Comparator<Tache>() {
			@Override
			public int compare(Tache arg0, Tache arg1) {
				return (int) (arg1.getId() - arg0.getId());
			}
		});
		
		Tache tache = new Tache();
		arrayList.add(tache);
		tache.setId(1);
		tache.setLabel("Le label");
		tache.setDatePrevu(new Date());
		
		arrayList.add(tache);
		
		return arrayList;
	}

	
	/**
	 * @return nombre de taches
	 */
	public synchronized long count() {
		return taches.size();
	}

	/**
	 * Supprime un élément
	 * @param value
	 */
	public synchronized void delete(Contact value) {
		taches.remove(value.getId());
	}

	/**
	 * Sauvegarde un élément
	 * @param entry
	 */
	public synchronized void save(Tache entry) {
		if (entry.getId() == null) {
			entry.setId(nextId++);
		}
		try {
			entry = (Tache) BeanUtils.cloneBean(entry);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		taches.put(entry.getId(), entry);
	}
}
