package project.model;

import javax.persistence.*;

@Entity
@Table(name = "thinks")
public class Think {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinTable(name = "user_thinks", joinColumns = @JoinColumn(name = "think_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User author;
    private String text;

    public Think() {
    }

    public Think(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
