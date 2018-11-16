package client;
/*
   Caian R. Ertl     (@caianrais)       - 20733152
   Diogo Casagrande  (@DiogoCasagrande) - 20718678
   Julia G. C. Chiba (@JuliaChiba)      - 20511823
 */

class Book
{
    private String title;
    private String author;
    private String publication;
    private String isbn;
    private int pages;

    public Book(String title,
            String author,
            String publication,
            String isbn,
            int pages)
    {
        this.title       = title;
        this.author      = author;
        this.publication = publication;
        this.isbn        = isbn;
        this.pages       = pages;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getPublication()
    {
        return this.publication;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    public int getPages()
    {
        return this.pages;
    }
}
