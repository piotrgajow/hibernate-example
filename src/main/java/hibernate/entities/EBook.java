package hibernate.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("e-book")
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
                "sizeKB=" + sizeKB +
                '}';
    }

}
