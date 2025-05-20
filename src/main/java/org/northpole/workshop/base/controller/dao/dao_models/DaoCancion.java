package org.northpole.workshop.base.controller.dao.dao_models;

import org.northpole.workshop.base.controller.dao.AdapterDao;
import org.northpole.workshop.base.models.Cancion;
/* import org.northpole.workshop.base.models.TipoArchivoEnum; */

public class DaoCancion extends AdapterDao<Cancion>{
    private Cancion obj;
    
    public DaoCancion() {
        super(Cancion.class);
    }
    
    public Cancion getObj() {
        if (obj == null) 
            this.obj = new Cancion();
        return obj;
    }

    public void setObj(Cancion obj) {
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

    public Boolean update(Integer pos) {
        try {
            this.update(obj ,obj.getId());
            return true;
        } catch (Exception e) {
            //Log de errores
            return false;
            // TODO: handle exception
        }
    }

    /* public static void main(String[] args) {
        DaoCancion dc = new DaoCancion();
        dc.getObj().setId(dc.listAll().getSize() + 1);
        dc.getObj().setNombre("Aventura");
        dc.getObj().setGenero("1");
        dc.getObj().setDuracion(3);
        dc.getObj().setUrl("https://www.youtube.com/watch?v=2V1v4g0j7xE");
        dc.getObj().setId_album(null);
        dc.getObj().setTipo(TipoArchivoEnum.FISICO);
        if (dc.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");
        }
        dc.setObj(null);
        dc.getObj().setId(dc.listAll().getSize() + 1);
        dc.getObj().setNombre("X");
        dc.getObj().setGenero("2");
        dc.getObj().setDuracion(5 );
        dc.getObj().setUrl("https://www.youtube.com/watch?v=2V1v4g0j7xE");
        dc.getObj().setId_album(null);
        dc.getObj().setTipo(TipoArchivoEnum.VIRTUAL);
        if (dc.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");
        }
    } */
}
