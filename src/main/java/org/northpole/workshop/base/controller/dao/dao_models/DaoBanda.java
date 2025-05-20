package org.northpole.workshop.base.controller.dao.dao_models;

import org.northpole.workshop.base.controller.dao.AdapterDao;
import org.northpole.workshop.base.models.Banda;

public class DaoBanda extends AdapterDao<Banda>{
    private Banda obj;
    
    public DaoBanda() {
        super(Banda.class);
    }
    
    public Banda getObj() {
        if (obj == null) 
            this.obj = new Banda();
        return obj;
    }

    public void setObj(Banda obj) {
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
        DaoBanda db = new DaoBanda();

        db.getObj().setId(db.listAll().getSize() + 1);
        db.getObj().setNombre("Wachiturros");
        db.getObj().setFecha(new Date());
        if (db.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");    
        }
        db.setObj(null);
        db.getObj().setId(db.listAll().getSize() + 1);
        db.getObj().setNombre("Tierra Canela");
        db.getObj().setFecha(new Date());
        if (db.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");    
        } 
        db.getObj().setId(1); // ID del objeto a actualizar
        db.getObj().setNombre("Enanitos Verdes");
        db.getObj().setFecha(new Date());
        if (db.update(0)) { // Actualiza el objeto en la posición 0
            System.out.println("Actualizado por posición");
        } else {
            System.out.println("Error al actualizar por posición");
        }
        /* db.setObj(new Banda());
        db.getObj().setNombre("Grupo 5");
        db.getObj().setFecha(new Date());
        if (db.update_By_Id( 2)){; // Actualiza el objeto con ID 2
            System.out.println("Actualizado por ID");
        } else {
            System.out.println("Error al actualizar por ID");
            
        }
    } */
}
