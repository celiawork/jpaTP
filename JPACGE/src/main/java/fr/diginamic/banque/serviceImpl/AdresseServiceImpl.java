package fr.diginamic.banque.serviceImpl;

import fr.diginamic.banque.model.EAdresse;
import fr.diginamic.banque.service.AdresseService;

public class AdresseServiceImpl implements AdresseService {

	@Override
	public EAdresse createAdresse(int numero, String rue, String ville, int codePostal) {

		EAdresse adresse = new EAdresse();
		adresse.setNumero(numero);
		adresse.setRue(rue);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);
		return adresse;

	}
}
