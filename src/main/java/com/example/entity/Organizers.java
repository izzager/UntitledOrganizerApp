package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="organizers")
public class Organizers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idGame;

    private String nameOrg;

    private String urlImage;

    public int getId() { return id; }

    public int getIdGame() { return idGame; }

    public String getNameOrg() { return nameOrg; }

    public String getUrlImage() { return urlImage; }

    @Override
    public String toString() {
        return "Organizers{" +
                "id=" + id +
                ", idGame=" + idGame +
                ", nameOrg='" + nameOrg + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizers that = (Organizers) o;
        return id == that.id &&
                idGame == that.idGame &&
                Objects.equals(nameOrg, that.nameOrg) &&
                Objects.equals(urlImage, that.urlImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idGame, nameOrg, urlImage);
    }
}
