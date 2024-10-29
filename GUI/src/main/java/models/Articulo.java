package models;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantAuthors() {
        return cantAuthors;
    }

    public void setCantAuthors(int cantAuthors) {
        this.cantAuthors = cantAuthors;
    }
}