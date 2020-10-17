package com.example.entity;

import javax.persistence.*;

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
}
