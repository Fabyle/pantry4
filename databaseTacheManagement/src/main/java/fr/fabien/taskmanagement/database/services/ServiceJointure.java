package fr.fabien.taskmanagement.database.services;

import java.util.List;
import java.util.Optional;

import fr.fabien.taskmanagement.database.business.EtatTache;
import fr.fabien.taskmanagement.database.business.Tache;

public class ServiceJointure {

	private static class InstanceHolder {
		public static ServiceJointure instance = new ServiceJointure();
	}

	private ServiceJointure() {
	}

	public static ServiceJointure getInstance() {
		return InstanceHolder.instance;
	}

	public void joindreTacheAvecEtatTache(List<Tache> taches, List<EtatTache> etatTache) {

		for (Tache tache : taches) {

			Optional<EtatTache> option = etatTache.stream().filter(a -> a.getCodeEtat()
					.equals(tache.get_BasicEtat()))
					.findFirst();
			option.ifPresent(x -> tache.setEtatTache(x));

		}

	}

}
