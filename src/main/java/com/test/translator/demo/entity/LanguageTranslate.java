package com.test.translator.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGE_TRANSLATE")
public class LanguageTranslate {

    @GeneratedValue()
    @Id
    private String id;

    @Column(name = "nbr")
    private Integer nbr;

    @Column(name = "message")
    private String message;

    @Column(name = "langue")
    private String langue;

    public void setId(String id) {
        this.id = id;
    }

    public void setNbr(Integer nbr) {
        this.nbr = nbr;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getId() {
        return id;
    }

    public Integer getNbr() {
        return nbr;
    }

    public String getMessage() {
        return message;
    }

    public String getLangue() {
        return langue;
    }


    @Override
    public String toString() {
        return "LanguageTranslate{" +
                ", number=" + nbr +
                ", message='" + message +
                ", message='" + langue + '\'' +
                '}';
    }
}
