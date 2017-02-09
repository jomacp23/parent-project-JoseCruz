package com.datamodel.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
@Entity
@Table(name = "books_out_on_loan")
@NamedQuery(name = "BookOutOnLoan.findByStudent",
    query = "SELECT b FROM BookOutOnLoan b WHERE b.student.idStudent = ?1")
public class BookOutOnLoan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBookBorrowing", unique = true, nullable = false)
    private Integer idBookBorrowing;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowerStudent_id", nullable = false)
    private Student student;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "isbn")
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_issued", length = 0)
    private Date dateIssued;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_due_for_return", length = 0)
    private Date dateDueForReturn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_returned", length = 0)
    private Date dateReturned;

    @Column(name = "amount_of_fine", precision = 10)
    private BigDecimal amountOfFine;

    public BookOutOnLoan() {
    }

    public Integer getIdBookBorrowing() {
        return idBookBorrowing;
    }

    public void setIdBookBorrowing(Integer idBookBorrowing) {
        this.idBookBorrowing = idBookBorrowing;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public Date getDateDueForReturn() {
        return dateDueForReturn;
    }

    public void setDateDueForReturn(Date dateDueForReturn) {
        this.dateDueForReturn = dateDueForReturn;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public BigDecimal getAmountOfFine() {
        return amountOfFine;
    }

    public void setAmountOfFine(BigDecimal amountOfFine) {
        this.amountOfFine = amountOfFine;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("BookOutOnLoan [idBookBorrowing=").append(idBookBorrowing).append(", ");
        sb.append("student=").append(student.toString()).append(", ");
        sb.append("book=").append(book.toString()).append(", ");
        sb.append("dateIssued=").append(dateIssued).append(", ");
        sb.append("dateDueForReturn=").append(dateDueForReturn).append(", ");
        sb.append("dateReturned=").append(dateReturned).append(", ");
        sb.append("amountOfFine=").append(amountOfFine).append("]");

        return sb.toString();
    }
}
