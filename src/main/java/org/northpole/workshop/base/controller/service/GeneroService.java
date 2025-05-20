package org.northpole.workshop.base.controller.service;

import java.util.Arrays;
import java.util.List;

import org.northpole.workshop.base.controller.dao.dao_models.DaoGenero;
import org.northpole.workshop.base.models.Genero;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed
public class GeneroService {
    private DaoGenero dg;
    
    public GeneroService() {
        dg = new DaoGenero();
    }

    public void createGenero(@NotEmpty String nombre) throws Exception {
        if (nombre.trim().length() > 0) {
            dg.getObj().setNombre(nombre);
            if (!dg.save()) 
                throw new Exception("tu genero no existe :D");
        }
    }

    public void updateGenero(Integer id, @NotEmpty String nombre) throws Exception {
        if (id != null && id > 0 && nombre.trim().length() > 0) {
            dg.setObj(dg.listAll().get(id - 1));
            dg.getObj().setNombre(nombre);
            if (!dg.update(id - 1)) 
                throw new Exception("tu genero no podra modificarse :D");
        }
    }

    public List<Genero> listAllGenero() {
        return Arrays.asList(dg.listAll().toArray());
    }

    /* HashMap para el artistaBandaServices para buscar datos de bandna y artista por posicion (no getById)
     * publiic list<Hashmap> listAll(){
        * list<Hashmap> list = new ArrayList<>();
        * if(!dg.listAll().isEmpty()){
        * Artista_Banda[] arreglo = dg.listAll().toArray();
        * DaoArtista dg = new DaoArtista();
        * DaoBanda dg = new DaoBanda();
            * for (int i = 0; i < arreglo.length; i++) {
                * HashMap<String, String (puede variar ejm: int, object, date, etc) > aux = new HashMap<>();
                * aux.put("id", arreglo[i].getId().toString(i));
                * aux.put("rol", arreglo[i].getRol().toString()
                * aux.put("artista", dg.listAll().get(arreglo[i].getIdArtista() - 1).getNombre());
                * aux.put("banda", dg.listAll().get(arreglo[i].getIdBanda() - 1).getNombre());
                * list.add(aux);
            * }
         * }
         * return list;
     * }
     * 
     * copy para la banda, crear un nuevo objeto banda y copiar los datos de otro objeto banda (se pone en banda.java)
     * public voi copy(banda obj){
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
