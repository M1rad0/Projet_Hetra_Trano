package hetra.back.entities;

import java.sql.Connection;
import java.sql.Date;

import bean.ClassMAPTable;

public class Prix extends ClassMAPTable{
    String id_prix;
    double valeur_m2;
    Date date_prix;

    public String getId_prix() {
        return id_prix;
    }

    public void setId_prix(String id_prix) {
        this.id_prix = id_prix;
    }

    public double getValeur_m2() {
        return valeur_m2;
    }

    public void setValeur_m2(double valeur_m2) {
        this.valeur_m2 = valeur_m2;
    }

    public Date getDate_prix() {
        return date_prix;
    }

    public void setDate_prix(Date date_prix) {
        this.date_prix = date_prix;
    }

    @Override
    public String getAttributIDName() {
        return "id_prix";
    }

    @Override
    public String getTuppleID() {
        return this.id_prix;
    }

    public Maison(){
        this.setNomTable("Prix");
    }

    @Override
    public void construirePK(Connection c) throws Exception {
        this.preparePk("PRI", "getNomSeq('seq_prix')");
        this.setId_maison(makePK(c));
    }
}
