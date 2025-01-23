package hetra.back.entities;

import java.sql.Connection;
import java.sql.Date;

import bean.ClassMAPTable;

public class Paiement extends ClassMAPTable{
    String id_paiement;
    double valeur_paiement;
    Date date_paiement;
    int mois;
    int annee;
    String id_maison;

    @Override
    public String getAttributIDName() {
        return "id_paiement";
    }
    @Override
    public String getTuppleID() {
        return id_paiement;
    }

    public Paiement(){
        this.setNomTable("Paiement");
    }

    @Override
    public void construirePK(Connection c) throws Exception {
        this.preparePk("PAI", "getNomSeq('seq_paiement')");
        this.setId_paiement(makePK(c));
    }

    public String getId_paiement() {
        return id_paiement;
    }
    public void setId_paiement(String id_paiement) {
        this.id_paiement = id_paiement;
    }
    public double getValeur_paiement() {
        return valeur_paiement;
    }
    public void setValeur_paiement(double valeur_paiement) {
        this.valeur_paiement = valeur_paiement;
    }
    public int getMois() {
        return mois;
    }
    public void setMois(int mois) {
        this.mois = mois;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public String getId_maison() {
        return id_maison;
    }
    public void setId_maison(String id_maison) {
        this.id_maison = id_maison;
    }
    public Date getDate_paiement() {
        return date_paiement;
    }
    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }
}
