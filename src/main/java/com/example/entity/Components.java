package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "components")
public class Components {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idOrganizer;

    private String nameComponent;

    private String urlComponent;

    public Components() {}

    public Components(int idOrganizer, String nameComponent, String urlComponent) {
        this.idOrganizer = idOrganizer;
        this.nameComponent = nameComponent;
        this.urlComponent = urlComponent;
    }

    public int getId() { return id; }

    public int getIdOrganizer() { return idOrganizer; }

    public String getNameComponent() { return nameComponent; }

    public String getUrlComponent() { return urlComponent; }

    public void setId(int id) { this.id = id; }

    public void setIdOrganizer(int idOrganizer) { this.idOrganizer = idOrganizer; }

    public void setNameComponent(String nameComponent) { this.nameComponent = nameComponent; }

    public void setUrlComponent(String urlComponent) { this.urlComponent = urlComponent; }

    @Override
    public String toString() {
        return "Components{" +
                "id=" + id +
                ", idOrganizer=" + idOrganizer +
                ", nameComponent='" + nameComponent + '\'' +
                ", urlComponent='" + urlComponent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Components that = (Components) o;
        return id == that.id &&
                idOrganizer == that.idOrganizer &&
                Objects.equals(nameComponent, that.nameComponent) &&
                Objects.equals(urlComponent, that.urlComponent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idOrganizer, nameComponent, urlComponent);
    }
}
