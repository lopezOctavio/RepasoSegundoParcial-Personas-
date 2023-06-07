package clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.util.*;

public class Persona {
    private boolean active;
    private int id;
    private int age;
    private String eyeColor;
    private String nombre;
    private String genero;
    private String registered;
    private Double latitude;
    private Double longitude;
    private List<String> tags;
    private List<Libro> book;

    public Persona() {
        this.tags = new ArrayList<>();
        this.book = new ArrayList<>();
    }

    public Persona(boolean active, int id, int age, String eyeColor, String nombre, String genero, String registered, Double latitude, Double longitude) {
        this.active = active;
        this.id = id;
        this.age = age;
        this.eyeColor = eyeColor;
        this.nombre = nombre;
        this.genero = genero;
        this.registered = registered;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tags = new ArrayList<>();
        this.book = new ArrayList<>();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<String> getEtiquetas() {
        return tags;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.tags = etiquetas;
    }

    public List<Libro> getLibros() {
        return book;
    }

    public void setLibros(List<Libro> libros) {
        this.book = libros;
    }

    @Override
    public String toString() {
        return "\nPersona{" +
                "active=" + active +
                ", id=" + id +
                ", age=" + age +
                ", eyeColor='" + eyeColor + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", registered='" + registered + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", etiquetas=" + tags +
                ", libros=" + book +
                '}';
    }

    public List<Persona> readPersonaJson(String file){
        try{
            FileReader reader = new FileReader(file);
            Gson gson = new GsonBuilder().create();
            Persona[] arrayPersonas = gson.fromJson(reader, Persona[].class);
            return Arrays.asList(arrayPersonas);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
