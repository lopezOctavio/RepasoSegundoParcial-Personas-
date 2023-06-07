package org.example;

import clases.Libro;
import clases.ListaGenerica;
import clases.Persona;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            /*File file = new File("generated.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Persona> personas = new ArrayList<>();
            personas = mapper.readValue(file, personas.getClass());
            System.out.println(personas.toString());*/

            Persona persona = new Persona();
            List<Persona> personas = persona.readPersonaJson("generated.json");
            System.out.println(personas);

            ListaGenerica<Persona> personasFiltradas = new ListaGenerica<>();
            personasFiltradas.personasFiltradasPorEdad(personas, 18);
            System.out.println(personasFiltradas);

            HashSet<String> autores = personasFiltradas.lista2HashSet();
            System.out.println(autores);

            HashMap<Integer, ArrayList<String>> etiquetas = personasFiltradas.lista2HashMap();
            System.out.println(etiquetas);

            int cantEtiquetas = personasFiltradas.cantidadEtiquetas(2);
            System.out.println(cantEtiquetas);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}