package hetra.back.entities;

import java.sql.Connection;
import bean.ClassMere;

public class Arrondissement extends ClassMere{
    String id_arrondissement;
    String nom_arrondissement;
    public String getId_arrondissement() {
        return id_arrondissement;
    }
    public void setId_arrondissement(String id_arrondissement) {
        this.id_arrondissement = id_arrondissement;
    }
    public String getNom_arrondissement() {
        return nom_arrondissement;
    }
    public void setNom_arrondissement(String nom_arrondissement) {
        this.nom_arrondissement = nom_arrondissement;
    }
    @Override
    public String getAttributIDName() {
        return "id_arrondissement";
    }

    @Override
    public String getTuppleID() {
        return this.id_arrondissement;
    }

    public Arrondissement() throws Exception{
        this.setNomTable("ARRONDISSEMENT");
        this.setNomClasseFille("java.hetra.back.entite.Point");
        this.setLiaisonFille("id_arrondissement");
    }

    @Override
    public void construirePK(Connection c) throws Exception {
        this.preparePk("ARR", "getNomSeq('seq_arrondissement')");
        this.setId_arrondissement(makePK(c));
    }


    
}
