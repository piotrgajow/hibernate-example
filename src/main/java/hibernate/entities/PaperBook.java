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
@Table(name = "paper_books")
public class PaperBook extends Book {

    @Column(name = "has_hard_cover")
    private Boolean hasHardCover;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    public PaperBook() {
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

    @Override
    public String toString() {
        return "PaperBook{" +
                "hasHardCover=" + hasHardCover +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
