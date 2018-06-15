package hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "e_books")
public class EBook extends Book {

    @Column(name = "size_kb")
    private Integer sizeKB;

    public EBook() {
    }

    public Integer getSizeKB() {
        return sizeKB;
    }

    public void setSizeKB(Integer sizeKB) {
        this.sizeKB = sizeKB;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", releaseDate=" + getReleaseDate() +
                ", sizeKB=" + sizeKB +
                '}';
    }

}
