package excepeciones;

public class EdadInvalida_E extends Exception{

    private int edad;

    public EdadInvalida_E(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String getMessage() {
        return "<!> Edad invalida ";
    }
}
