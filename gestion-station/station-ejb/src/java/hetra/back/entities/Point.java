package hetra.back.entities;

import java.sql.Connection;

import bean.ClassFille;

public class Point extends ClassFille {
    String id_point_arrondissement;
    double lattitude;
    double longitude;
    String id_arrondissement;
    
    public Point() throws Exception{
        this.setNomTable("POINT_ARRONDISSEMENT");
        this.setLiaisonMere("id_arrondissement");
        Point.setNomClasseMere("Arrondissement");
    }
    public String getId_point_arrondissement() {
        return id_point_arrondissement;
    }
    public void setId_point_arrondissement(String id_point_arrondissement) {
        this.id_point_arrondissement = id_point_arrondissement;
    }
    public double getLattitude() {
        return lattitude;
    }
    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @Override
    public String getAttributIDName() {
        return "id_arrondissement";
    }

    @Override
    public String getTuppleID() {
        return this.id_point_arrondissement;
    }

    

    @Override
    public void construirePK(Connection c) throws Exception {
        this.preparePk("POI", "getNomSeq('seq_point_arrondissement')");
        this.setId_point_arrondissement(makePK(c));
    }
    public String getId_arrondissement() {
        return id_arrondissement;
    }
    public void setId_arrondissement(String id_arrondissement) {
        this.id_arrondissement = id_arrondissement;
    }
    
    
}
