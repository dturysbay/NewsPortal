package news.portal.bitlab.kz.db;

public class News {
    Long id;
    String post_date;
    Long category_id;
    String title;
    String content;

    public News(){
    }

    public News(Long id, String post_date, Long category_id, String title, String content) {
        this.id = id;
        this.post_date = post_date;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
