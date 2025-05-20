package org.northpole.workshop.base.controller.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.northpole.workshop.base.controller.dao.dao_models.DaoBanda;
import org.northpole.workshop.base.models.Banda;
import org.springframework.data.domain.Pageable;

import com.github.javaparser.quality.NotNull;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed
public class BandaService {
    private DaoBanda db;
    
    public BandaService() {
        db = new DaoBanda();
    }

    public void createBanda(@NotEmpty String nombre, @NonNull Date fecha) throws Exception {
        if (nombre.trim().length() > 0 && fecha.toString().length() > 0) {
            db.getObj().setNombre(nombre);
            db.getObj().setFecha(fecha);
            if (!db.save()) 
                throw new Exception("tu banda no existe :D");
        }
    }

    public void updateBanda(Integer id, @NotEmpty String nombre, @NonNull Date fecha) throws Exception {
        if (id != null && id > 0 && nombre.trim().length() > 0 && fecha.toString().length() > 0) {
            db.setObj(db.listAll().get(id - 1));
            db.getObj().setNombre(nombre);
            db.getObj().setFecha(fecha);
            if (!db.update(id - 1)) 
                throw new Exception("tu banda no podra modificarse :D");
        }
    }

    public List<Banda> listAllBanda(){
        return Arrays.asList(db.listAll().toArray());
    }

    public List<HashMap> listBanda(){
        List<HashMap> lista = new ArrayList<>();
        if(!db.listAll().isEmpty()) {
            Banda [] arreglo = db.listAll().toArray();
           
            for(int i = 0; i < arreglo.length; i++) {
                
                HashMap<String, String> aux = new HashMap<>();
                aux.put("id", arreglo[i].getId().toString(i));                
                aux.put("nombre", arreglo[i].getNombre());
                lista.add(aux);
            }
        }
        return lista;
    }
    /* HashMap para el artistaBandaServices para buscar datos de bandna y artista por posicion (no getById)
     * publiic list<Hashmap> listAll(){
        * list<Hashmap> list = new ArrayList<>();
        * if(!db.listAll().isEmpty()){
        * Artista_Banda[] arreglo = db.listAll().toArray();
        * DaoArtista da = new DaoArtista();
        * DaoBanda db = new DaoBanda();
            * for (int i = 0; i < arreglo.length; i++) {
                * HashMap<String, String (puede variar ejm: int, object, date, etc) > aux = new HashMap<>();
                * aux.put("id", arreglo[i].getId().toString(i));
                * aux.put("rol", arreglo[i].getRol().toString()
                * aux.put("artista", da.listAll().get(arreglo[i].getIdArtista() - 1).getNombre());
                * aux.put("banda", db.listAll().get(arreglo[i].getIdBanda() - 1).getNombre());
                * list.add(aux);
            * }
         * }
         * return list;
     * }
     * 
     * copy para la banda, crear un nuevo objeto banda y copiar los datos de otro objeto banda (se pone en banda.java)
     * public void copy(banda obj){
     *  Banda aux = new Banda();
     *  this.fecha = obj.getFecha();
     *  this.nombre = obj.getNombre();
     *  this.id = obj.getId();
     * }
     * 
     * public HashMap<String, Object> toDict{
     *  HashMap<String, Object> dict = new HashMap<>();
     *  dict.put("id", this.getid);
     *  dict.put("nombre", this.getNombre);
     *  dict.put("fecha", this.getFecha);
     *  return dict;
     * }
     * 
     * se implementa en el lisdt<Hashmap> (para mejorar el rendimiento)
     * arreglo[i].toDict();
     * 
     * 
     * Para el apartado de la vista (obj.list):
     * export default function ArtistaBandaList(){
     *  const dataProvider = UseDataProvider({
     *   list: () => ArtistaBandaServices.listAll(){
     * }
     * 
     * */
    
}
