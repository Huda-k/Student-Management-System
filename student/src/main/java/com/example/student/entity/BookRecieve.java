package com.example.student.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Table(name = "book_recieve ")
public class BookRecieve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recieve_id")
    private int recieveId;
    @Column(name = "recieve_date")
    private Date recieveDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Library library;

    public int getRecieveId() {
        return recieveId;
    }

    public void setRecieveId(int recieveId) {
        this.recieveId = recieveId;
    }

    public Date getRecieveDate() {
        return recieveDate;
    }

    public void setRecieveDate(Date recieveDate) {
        this.recieveDate = recieveDate;
    }
}