package org.northpole.workshop.base.controller.dao.dao_models;


import org.northpole.workshop.base.controller.dao.AdapterDao;
import org.northpole.workshop.base.models.Album;

public class DaoAlbum extends AdapterDao<Album>{
    private Album obj;
    
    public DaoAlbum() {
        super (Album.class);
    }
    
    public Album getObj() {
        if (obj == null) 
            this.obj = new Album();
        return obj;
    }

    public void setObj(Album obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            obj.setId(listAll().getSize() + 1);
            this.persist(obj);
            return true;
        } catch (Exception e) {
            //Log de errores
            e.printStackTrace();
            System.out.println(e);
            return false;
            // TODO: handle exception
        }
    }

    public Boolean update(Integer pos){
        try {
            this.update(obj,pos);
            return true;
        } catch (Exception e) {
            System.out.println("Objerto no guardado" + e.getMessage());
            return false;
        }
    }

    public Boolean update_By_Id(Integer id){
        try {
            this.update_id(obj, id);
            return true;
        } catch (Exception e) {
            System.out.println("Objerto no guardado" + e.getMessage());
            return false;
        }
    }

    /* public static void main(String[] args) {
        DaoAlbum da = new DaoAlbum();

        da.getObj().setId(da.listAll().getSize() + 1);
        da.getObj().setNombre("Wachiturros");
        da.getObj().setFecha(new Date());
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");    
        }
        da.setObj(null);
        da.getObj().setId(da.listAll().getSize() + 1);
        da.getObj().setNombre("Tierra Canela");
        da.getObj().setFecha(new Date());
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");    
        } 
        da.getObj().setId(1); // ID del objeto a actualizar
        da.getObj().setNombre("Enanitos Verdes");
        da.getObj().setFecha(new Date());
        if (da.update(0)) { // Actualiza el objeto en la posición 0
            System.out.println("Actualizado por posición");
        } else {
            System.out.println("Error al actualizar por posición");
        }
        /* da.setObj(new Album());
        da.getObj().setNombre("Grupo 5");
        da.getObj().setFecha(new Date());
        if (da.update_By_Id( 2)){; // Actualiza el objeto con ID 2
            System.out.println("Actualizado por ID");
        } else {
            System.out.println("Error al actualizar por ID");
            
        }
    } */
}
