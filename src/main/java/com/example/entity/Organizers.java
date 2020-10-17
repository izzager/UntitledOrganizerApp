package com.example.entity;

import javax.persistence.*;

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

    public void setId(int id) { this.id = id; }

    public void setIdGame(int idGame) { this.idGame = idGame; }

    public void setNameOrg(String nameOrg) { this.nameOrg = nameOrg; }

    public void setUrlImage(String urlImage) { this.urlImage = urlImage; }

    @Override
    public String toString() {
        return "Organizers{" +
                "id=" + id +
                ", idGame=" + idGame +
                ", nameOrg='" + nameOrg + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
