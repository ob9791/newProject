package com.tsi.o.blidi.program.Language;

import javax.persistence.*;

@Entity
@Table(name="language")

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")

    // Attributes

    private int languageId;
    private String lang;

    // Constructor

    public Language(int languageId, String lang) {
        this.languageId = languageId;
        this.lang = lang;
    }

    public Language(){}

    // Getters nd setters

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}