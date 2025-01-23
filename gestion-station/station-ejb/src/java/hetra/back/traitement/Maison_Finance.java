package hetra.back.traitement;

import java.sql.Date;

import bean.CGenUtil;
import hetra.back.entities.Maison;
import hetra.back.entities.Paiement;

public class Maison_Finance extends Maison{
    double totalAPayer;
    double totalPaye;
    double resteAPayer;
    Object[] allPaiements;
    Date referenciel;
    
    public Maison_Finance(Maison init, Date daty) throws Exception{
        super();
        this.setId_maison(init.getId_maison());
        this.setAdresse(init.getAdresse());
        this.setLatitude(init.getLatitude());
        this.setLongitude(init.getLongitude());
        this.setLargeur(init.getLargeur());
        this.setLongueur(init.getLongueur());

        Object[] getAllPaiement=CGenUtil.rechercher(new Paiement(),"SELECT * FROM Paiement WHERE id_maison='"+this.getId_maison()+"' AND date_paiement<='"+referenciel.toString()+"'");
        this.setAllPaiements(getAllPaiement);
    }

    public double getTotalAPayer() {
        return totalAPayer;
    }

    public void setTotalAPayer(double totalAPayer) {
        this.totalAPayer = totalAPayer;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }

    public double getResteAPayer() {
        return resteAPayer;
    }

    public void setResteAPayer(double resteAPayer) {
        this.resteAPayer = resteAPayer;
    }

    public Object[] getAllPaiements() {
        return allPaiements;
    }

    public void setAllPaiements(Object[] allPaiements) {
        this.allPaiements = allPaiements;
    }

    public double calculerTotalPaiement(){
        double result = 0;
        for (Object paiement : allPaiements) {
            Paiement toPaiement=paiement;

            result+=toPaiement.getValeur_paiement();
        }

        return result;
    }

    public double calculerHetraTranoMensuel(){
        Prix price=CGenUtil.rechercher(new Prix(), "SELECT * FROM Prix WHERE date_prix <='"+this.referenciel.toString()+"'");

        
    }
}
