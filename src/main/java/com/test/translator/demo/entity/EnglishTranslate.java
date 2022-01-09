package com.test.translator.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "English_Translate")
public class EnglishTranslate {

    @Id
    @SequenceGenerator(name = "s_EnglishTranslate")

    @Column(name = "number")
    private Integer number;

    @Column(name = "message")
    private String message;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String   toString() {
        return "EnglishTranslate{" +
                ", number=" + number +
                ", message='" + message + '\'' +
                '}';
    }
}
