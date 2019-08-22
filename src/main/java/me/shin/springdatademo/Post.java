package me.shin.springdatademo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Comment> comment = new HashSet<>();

    public void addComment(Comment comment) {
        this.getComment().add(comment);
        comment.setPost(this);
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

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            '}';
    }
}
