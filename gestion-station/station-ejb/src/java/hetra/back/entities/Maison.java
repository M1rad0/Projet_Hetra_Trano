package hetra.back.entities;
import java.sql.Connection;

import bean.CGenUtil;
import bean.ClassMAPTable;

public class Maison extends ClassMAPTable {
    String id_maison;
    String adresse;
    double latitude;
    double longitude;
    double largeur;
    double longueur;
    int nb_etage;

    public String getId_maison() {
        return id_maison;
    }

    public void setId_maison(String id_maison) {
        this.id_maison = id_maison;
    }
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double lattitude) {
        this.latitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public int getNb_etage() {
        return nb_etage;
    }

    public void setNb_etage(int nb_etage) {
        this.nb_etage = nb_etage;
    }
    @Override
    public String getAttributIDName() {
        return "id_maison";
    }

    @Override
    public String getTuppleID() {
        return this.id_maison;
    }

    public Maison(){
        this.setNomTable("MAISON");
    }

    @Override
    public void construirePK(Connection c) throws Exception {
        this.preparePk("MAI", "getNomSeq('seq_maison')");
        this.setId_maison(makePK(c));
    }

    public static Object[] getAll() throws Exception{
        Maison object=new Maison();
        Object[] result=CGenUtil.rechercher(object,"SELECT * FROM Maison");

        return result;
    }
}
