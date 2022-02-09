package com.test.translator.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "HISTORY_LANGUAGE")
public class HistoryLanguage {

    public HistoryLanguage(Long id, Integer nbr, String langue, String date) {
        this.id = id;
        this.nbr = nbr;
        this.langue = langue;
        this.date = date;
    }

    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "nbr")
    private Integer nbr;

    @Column(name = "langue")
    private String langue;

    @Column(name = "date")
    private String date;

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
