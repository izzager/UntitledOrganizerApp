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
    private String game_name;

    //@Column
    private String url_image;

    public Games() { }

    public int getId() { return id; }

    public String getGame_name() { return game_name; }

    public String getUrl_image() { return url_image; }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", game_name='" + game_name + '\'' +
                ", url_image='" + url_image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return id == games.id &&
                Objects.equals(game_name, games.game_name) &&
                Objects.equals(url_image, games.url_image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game_name, url_image);
    }
}
