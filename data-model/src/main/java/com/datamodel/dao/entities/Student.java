package com.datamodel.dao.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students", uniqueConstraints =
    @UniqueConstraint(columnNames = "email_adress"))
@NamedQuery(name = "Student.findByFirstName",
    query = "SELECT s FROM Student s WHERE s.firstName = ?1")
public class Student implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStudent", unique = true, nullable = false)
	private Integer idStudent;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    @Column(name = "student_adress")
    private String studentAdress;

    @Column(name = "phone_number", length = 25)
    private String phoneNumber;

    @Column(name = "email_adress", unique = true, length = 45)
    private String emailAdress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
    private Set<BookOutOnLoan> booksOutOnLoans = new HashSet<BookOutOnLoan>();

    public Student() {
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
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

    public String getStudentAdress() {
        return studentAdress;
    }

    public void setStudentAdress(String studentAdress) {
        this.studentAdress = studentAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public Set<BookOutOnLoan> getBooksOutOnLoans() {
        return booksOutOnLoans;
    }

    public void setBooksOutOnLoans(Set<BookOutOnLoan> booksOutOnLoans) {
        this.booksOutOnLoans = booksOutOnLoans;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Student [idStudent=").append(idStudent).append(", ");
        sb.append("firstName=").append(firstName).append(", ");
        sb.append("lastName=").append(lastName).append(", ");
        sb.append("studentAdress=").append(studentAdress).append(", ");
        sb.append("phoneNumber=").append(phoneNumber).append(", ");
        sb.append("emailAdress=").append(emailAdress).append("]");

        return sb.toString();
    }
}
