package hu.nye.progkornyezet.vasarlasilista.model;

import java.util.Objects;

public class Products {

    private int id;
    private String title;
    private String maker;
    private Genre genre;

    public Products(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Products(int id, String title, String maker, Genre genre) {
        this.id = id;
        this.title = title;
        this.maker = maker;
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, maker, genre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Products)) {
            return false;
        }
        Products products = (Products) o;
        return id == products.id && Objects.equals(title, products.title) && Objects.equals(maker, products.maker)
                && genre == products.genre;
    }

    @Override
    public String toString() {
        return "Products{"
                +
                "id=" + id
                +
                ", title='" + title + '\''
                +
                ", maker='" + maker + '\''
                +
                ", genre=" + genre
                +
                '}';
    }
}
