package clases;

import excepeciones.Custom_E;
import excepeciones.EdadInvalida_E;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ListaGenerica <T extends Persona>{
    private List<T> elementos = new ArrayList<>();

    public List<T> getElementos(){
        return elementos;
    }

    @Override
    public String toString() {
        return "ListaGenerica{" +
                "elementos=" + elementos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaGenerica<?> that = (ListaGenerica<?>) o;
        return Objects.equals(elementos, that.elementos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementos);
    }

    public void personasFiltradasPorEdad(List<T> lista, int filtro) throws EdadInvalida_E {
        lista.forEach( persona-> {
            if(persona.getAge()>=filtro){
                elementos.add(persona);
            }else{
                try {
                    throw new EdadInvalida_E(persona.getAge());
                }catch (EdadInvalida_E e){
                    System.out.println("<!> Excepecion "+e.getMessage()+"Edad Ingresada - "+e.getEdad());

                }

            }
        });
    }

    public HashSet<String> lista2HashSet(){
        HashSet<String> setAutores = new HashSet<>();
        elementos.forEach(persona-> {
            persona.getLibros().forEach(libro -> {
                setAutores.add(libro.getAutor());
            });
        });
        return setAutores;
    }

    /**Desde la lista genérica pasar a un hashmap todas las etiquetas. La clave será
    el id de la persona y el valor un arraylist con las etiquetas.*/

    public HashMap<Integer, ArrayList<String>> lista2HashMap(){
        HashMap<Integer, ArrayList<String>> mapEtiquetas = new HashMap<>();
        elementos.forEach(elemento->{
            mapEtiquetas.put(elemento.getId(), (ArrayList<String>) elemento.getEtiquetas());
        });
        return mapEtiquetas;
    }

    public int cantidadEtiquetas(int id)throws Custom_E {
        AtomicBoolean clave = new AtomicBoolean(false);
        AtomicInteger contador = new AtomicInteger(0);
        elementos.forEach(persona->{
            if(id==persona.getId()){
                persona.getEtiquetas().forEach(etiqueta->{
                    contador.incrementAndGet();
                    clave.set(true);
                });
            }
        });
        if(!clave.get()){
            throw new Custom_E("id invalido");
        }
        return contador.get();
    }



}
