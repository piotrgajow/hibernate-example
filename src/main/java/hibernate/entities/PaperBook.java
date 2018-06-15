package hibernate.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("paper")
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
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", releaseDate=" + getReleaseDate() +
                ", hasHardCover=" + hasHardCover +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
