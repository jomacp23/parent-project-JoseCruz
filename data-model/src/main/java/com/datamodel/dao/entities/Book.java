package com.datamodel.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
@Entity
@Table(name = "books")
@NamedQuery(name = "Book.findByTitle",
    query = "SELECT b FROM Book b WHERE b.title = ?1")
public class Book implements Serializable {

    @Id
    @Column(name = "isbn", unique = true, nullable = false, length = 14)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_publication", length = 0)
    private Date dateOfPublication;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookOutOnLoan> booksOutOnLoan = new HashSet<BookOutOnLoan>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books", cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "books_by_category", joinColumns = {
        @JoinColumn(name = "isbn", nullable = false, updatable = false) }, inverseJoinColumns = {
        @JoinColumn(name = "idCategory", nullable = false, updatable = false) })
    private Set<Category> categories = new HashSet<Category>();

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public Set<BookOutOnLoan> getBooksOutOnLoan() {
        return booksOutOnLoan;
    }

    public void setBooksOutOnLoan(Set<BookOutOnLoan> booksOutOnLoan) {
        this.booksOutOnLoan = booksOutOnLoan;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Book [isbn=").append(isbn).append(", ");
        sb.append("title=").append(title).append(", ");
        sb.append("dateOfPublication=").append(dateOfPublication).append("]");

        return sb.toString();
    }
}
