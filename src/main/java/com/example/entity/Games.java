package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "games")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@Column
    private String gameName;

    //@Column
    private String urlImage;

    public Games() { }

    public int getId() { return id; }

    public String getGame_name() { return gameName; }

    public String getUrl_image() { return urlImage; }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", game_name='" + gameName + '\'' +
                ", url_image='" + urlImage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return id == games.id &&
                Objects.equals(gameName, games.gameName) &&
                Objects.equals(urlImage, games.urlImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameName, urlImage);
    }
}
