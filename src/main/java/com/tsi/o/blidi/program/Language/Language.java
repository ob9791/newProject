package com.tsi.o.blidi.program.Language;

import javax.persistence.*;

@Entity
@Table(name="language")

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Attributes

    private int language_id;
    private String lang;

    // Constructor

    public Language(int language_id, String lang) {
        this.language_id = language_id;
        this.lang = lang;
    }

    public Language(){}

    // Getters nd setters

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}