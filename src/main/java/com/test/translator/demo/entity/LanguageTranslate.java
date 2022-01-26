package com.test.translator.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "LanguageTranslate")
public class LanguageTranslate {

    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "nbr")
    private Integer nbr;

    @Column(name = "message")
    private String message;

    @Column(name = "langue")
    private String langue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbr() {
        return nbr;
    }

    public void setNbr(Integer nbr) {
        this.nbr = nbr;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    /*
    @Column(name = "frenchLangue")
    private String FR;

    @Column(name = "englishLangue")
    private String EN;

    @Column(name = "germanLangue")
    private String DE;
*/


    @Override
    public String toString() {
        return "LanguageTranslate{" +
                ", number=" + nbr +
                ", message='" + message +
                ", message='" + langue + '\'' +
                '}';
    }
}
