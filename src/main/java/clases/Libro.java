package clases;



public class Libro {
    private int ISBN;
    private String author;

    public Libro() {
    }

    public Libro(int ISBN, String autor) {
        this.ISBN = ISBN;
        this.author = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN=" + ISBN +
                ", autor='" + author + '\'' +
                '}';
    }
}
