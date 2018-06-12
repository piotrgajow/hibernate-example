package hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "has_hard_cover")
    private Boolean hasHardCover;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getHasHardCover() {
        return hasHardCover;
    }

    public void setHasHardCover(Boolean hasHardCover) {
        this.hasHardCover = hasHardCover;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        List<String> authorIds = authors.stream().map(author -> author.getId().toString()).collect(Collectors.toList());
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", hasHardCover=" + hasHardCover +
                ", numberOfPages=" + numberOfPages +
                ", releaseDate=" + releaseDate +
                ", authorIds=" + String.join(",", authorIds) +
                '}';
    }

}
