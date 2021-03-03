package Framework;

public class Author {

    private String nameAuthor = "Đang cập nhật";

    public Author() {
    }

    public Author(String nameAuthor) {
        this.setNameAuthor(nameAuthor);
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getNameAuthor() {
        return this.nameAuthor;
    }

    public String toSting() {
        return "Tác giả: " + this.getNameAuthor();
    }
}
