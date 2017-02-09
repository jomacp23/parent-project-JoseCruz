package com.datamodel.dao.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
@Entity
@Table(name = "author")
@NamedQuery(name = "Author.findByLastName",
    query = "SELECT a FROM Author a WHERE a.lastName = ?1")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAuthor", unique = true, nullable = false )
    private Integer idAuthor;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "books_by_author", joinColumns = {
        @JoinColumn(name = "idAuthor", nullable = false, updatable = false) }, inverseJoinColumns = {
        @JoinColumn(name = "isbn", nullable = false, updatable = false) })
    private Set<Book> books = new HashSet<Book>();

    public Author() {
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Author [idAuthor=").append(idAuthor).append(", ");
        sb.append("firstName=").append(firstName).append(", ");
        sb.append("lastName=").append(lastName).append("]");

        return sb.toString();
    }
}
