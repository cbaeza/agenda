package com.cbaeza.agenda.model;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * User: cbaeza
 * Since: 15.11.13
 */
@Entity
@Table(name = "agendas")
@XmlRootElement
@NamedNativeQueries({
        @NamedNativeQuery(name = "agendas.findAll", query = "SELECT * FROM agendas as a", resultClass = Agenda.class),
        @NamedNativeQuery(name = "agendas.findById", query = "SELECT * FROM agendas as a WHERE a.id = :id", resultClass = Agenda.class),
        @NamedNativeQuery(name = "agendas.findByTitle", query = "SELECT * FROM agendas as a WHERE a.title = :title", resultClass = Agenda.class),
        @NamedNativeQuery(name = "agendas.findByUser", query = "SELECT * FROM agendas as a WHERE a.user = :user", resultClass = Agenda.class),
        @NamedNativeQuery(name = "agendas.findByPassword", query = "SELECT * FROM agendas as a WHERE a.password = :password", resultClass = Agenda.class),
        @NamedNativeQuery(name = "agendas.findByUrl", query = "SELECT * FROM agendas as a WHERE a.url = :url", resultClass = Agenda.class),
        @NamedNativeQuery(name = "agendas.findByCreatedAt", query = "SELECT * FROM agendas as a WHERE a.createdAt = :createdAt", resultClass = Agenda.class),
        @NamedNativeQuery(name = "agendas.findByUpdatedAt", query = "SELECT * FROM agendas as a WHERE a.updatedAt = :updatedAt", resultClass = Agenda.class)})

public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(length = 255)
    private String title;
    @Size(max = 255)
    @Column(length = 255)
    private String user;
    @Size(max = 255)
    @Column(length = 255)
    private String password;
    @Size(max = 255)
    @Column(length = 255)
    private String url;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Agenda(Integer id, String title, String user, String password, String url, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.password = password;
        this.url = url;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Agenda() {
    }

    public Agenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agenda)) return false;

        Agenda agendas = (Agenda) o;

        if (id != null ? !id.equals(agendas.id) : agendas.id != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "com.cbaeza.agenda.model.Agendas[ id=" + id + " ]";
    }

}
