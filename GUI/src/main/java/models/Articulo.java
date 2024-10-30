package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Articulo {
    private Integer id;
    private String title;
    private String journal;
    private String abstractText;
    private String keywords;
    private Integer cantAuthors;
    
    public Articulo(String title, String journal, String abstractText, String keywords, Integer cantAuthors) {
        this.title = title;
        this.journal = journal;
        this.abstractText = abstractText;
        this.keywords = keywords;
        this.cantAuthors = cantAuthors;
        this.id = 0;
    }

    public Articulo(){}

    public String getTitle() {
        return title;
    }

    public String getJournal() {
        return journal;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getKeywords() {
        return keywords;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantAuthors() {
        return cantAuthors;
    }

    public void setCantAuthors(Integer cantAuthors) {
        this.cantAuthors = cantAuthors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    
}