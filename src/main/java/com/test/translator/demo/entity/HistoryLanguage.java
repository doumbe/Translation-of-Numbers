package com.test.translator.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "HISTORY_LANGUAGE")
public class HistoryLanguage {

    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "nbr")
    private Integer nbr;

    @Column(name = "langue")
    private String langue;

    @Column(name = "date")
    private String date;

    public HistoryLanguage(Integer nbr, String langue, String date) {
        this.nbr = nbr;
        this.langue = langue;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Integer getNbr() {
        return nbr;
    }

    public String getLangue() {
        return langue;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "LanguageTranslate{" +
                ", number=" + nbr +
                ", message='" + date +
                ", message='" + langue + '\'' +
                '}';
    }

}
