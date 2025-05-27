package dongne_be.week11.hashtag.entity;

import com.dongne.week11.book.entity.BookEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class HashtagEntity {

    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "hashtags")
    private List<BookEntity> book;
}
