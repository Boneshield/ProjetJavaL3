package control;

import java.util.ArrayList;
import java.util.List;

import model.BDClient;
import model.BDCommande;
import model.Carte;
import model.Client;
import model.Commande;
import model.Hamburger;
import model.Accompagnement;
import model.Boisson;

public class ControlCommander {
    private BDClient bdClient;
    private BDCommande bdCommande;
    
	public ControlCommander(Carte carte, BDClient bdClient,
			BDCommande bdCommande) {
		this.bdClient = bdClient;
		this.bdCommande = bdCommande;
	}
	
	public List<String> getListeHamburger(){
	    List<Hamburger> listeHamburger = Carte.getInstance().getListeHamburger();
	    List<String> listeReturn = new ArrayList<>();
	    for(Hamburger hamburger : listeHamburger){
	        listeReturn.add(hamburger.getNom());
	    }
	    return listeReturn;
	}
	
	public List<String> getListeAccompagnement(){
	    List<Accompagnement> listeAccompagnement = Carte.getInstance().getListeAccompagnement();
	    List<String> listeReturn = new ArrayList<>();
	    for(Accompagnement accompagnement : listeAccompagnement){
	        listeReturn.add(accompagnement.getNom());
	    }
	    return listeReturn;
	}
	
	public List<String> getListeBoisson(){
	    List<Boisson> listeBoisson = Carte.getInstance().getListeBoisson();
	    List<String> listeReturn = new ArrayList<>();
	    for(Boisson boisson : listeBoisson){
	        listeReturn.add(boisson.getNom());
	    }
	    return listeReturn;
	}
	
	public boolean isCarteRenseignee(int numClient){
	    Client client = bdClient.getClient(numClient);
	    return client.isCarteRenseignee();
	}
	
	public int enregistrerCommande(int numClient, int numHamburger, int numAccompagnement, int numBoisson){
	    Hamburger hamburger = Carte.getInstance().choixHamburger(numHamburger);
	    Accompagnement accompagnement = Carte.getInstance().choixAccompagnement(numAccompagnement);
	    Boisson boisson = Carte.getInstance().choixBoisson(numBoisson);
	    int numCommande = BDCommande.getInstance().enregistrerCommande(numClient, hamburger, accompagnement, boisson);
	    return numCommande;
	}
}
