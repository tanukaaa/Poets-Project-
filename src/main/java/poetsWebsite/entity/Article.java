package poetsWebsite.entity;

import javax.persistence.*;

/**
 * Created by Admin on 14.12.2016 г..
 */
@Entity
@Table(name = "articles")
public class Article {

    private Integer id;

    private String title;

    private String content;

    private User author;

    private Category category;


    public Article(String title, String content, User author, Category category){
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public Article () { }

    @Transient
    public String getSummary(){

        if(this.getContent().length() > 300){
            return  this.getContent().substring(0, 300) + ". . .";
        }

        return this.getContent();
    }

    @Transient
    public boolean isLessThan300(){
        if(this.getContent().length() < 300){
            return true;
        }
        return false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false, columnDefinition = "text")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @ManyToOne
    @JoinColumn(nullable = false, name = "categoryId")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne()
    @JoinColumn(nullable = false, name = "authorId")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
