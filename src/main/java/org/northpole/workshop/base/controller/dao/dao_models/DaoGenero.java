package org.northpole.workshop.base.controller.dao.dao_models;

import org.northpole.workshop.base.controller.dao.AdapterDao;
import org.northpole.workshop.base.models.Genero;

public class DaoGenero extends AdapterDao<Genero>{
    private Genero obj;
    
    public DaoGenero() {
        super (Genero.class);
    }
    
    public Genero getObj() {
        if (obj == null) 
            this.obj = new Genero();
        return obj;
    }

    public void setObj(Genero obj) {
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
        DaoAlbum dg = new DaoAlbum();

        dg.getObj().setId(dg.listAll().getSize() + 1);
        dg.getObj().setNombre("Wachiturros");
        dg.getObj().setFecha(new Date());
        if (dg.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");    
        }
        dg.setObj(null);
        dg.getObj().setId(dg.listAll().getSize() + 1);
        dg.getObj().setNombre("Tierra Canela");
        dg.getObj().setFecha(new Date());
        if (dg.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");    
        } 
        dg.getObj().setId(1); // ID del objeto a actualizar
        dg.getObj().setNombre("Enanitos Verdes");
        dg.getObj().setFecha(new Date());
        if (dg.update(0)) { // Actualiza el objeto en la posición 0
            System.out.println("Actualizado por posición");
        } else {
            System.out.println("Error al actualizar por posición");
        }
        /* dg.setObj(new Genero());
        dg.getObj().setNombre("Grupo 5");
        dg.getObj().setFecha(new Date());
        if (dg.update_By_Id( 2)){; // Actualiza el objeto con ID 2
            System.out.println("Actualizado por ID");
        } else {
            System.out.println("Error al actualizar por ID");
            
        } 
    } */
}
