package Framework;

import java.util.ArrayList;

public class Novel implements StatusAndCategory {

    private String nameNovel = "*Chưa được nhập";
    private String introNovel = "Đang cập nhật";
    private String status = nameStatus[0];
    private ArrayList<Integer> category = new ArrayList<>();
    private Author author;
    private ArrayList<Chapter> chapter;

    public Novel() {
    }

    public Novel(String nameNovel, String introNovel, String status, ArrayList<Integer> category, Author author, ArrayList<Chapter> chapter) {
        this.setNameNovel(nameNovel);
        this.setIntroNovel(introNovel);
        this.setStatus(status);
        this.setCategory(category);
        this.setAuthor(author);
        this.setChapter(chapter);
    }

    public String getNameNovel() {
        return this.nameNovel;
    }

    public void setNameNovel(String nameNovel) {
        if (nameNovel.length() > 0) {
            this.nameNovel = nameNovel;
        }
    }

    public String getIntroNovel() {
        return this.introNovel;
    }

    public void setIntroNovel(String introNovel) {
        if (introNovel.length() > 0) {
            this.introNovel = introNovel;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        if (status.equals(nameStatus[0]) || status.equals(nameStatus[1]) || status.equals(nameStatus[2])) {
            this.status = status;
        }
    }

    public String getCategory() {
        String result = "";
        if (this.category.size() >= 1) {
            for (int i = 0; i < this.category.size() - 1; i++) {
                result = result + listCategory[(int)(this.category.get(i))][0] + " - ";
            }
            result = result.concat(listCategory[(int)(this.category.get(this.category.size() - 1))][0]);
        } else {
            result = listCategory[(int)(this.category.get(0))][0];
        }
        return result;
    }

    public void setCategory(ArrayList<Integer> categoty) {
        this.category = categoty;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ArrayList<Chapter> getChapter() {
        return this.chapter;
    }

    public void setChapter(ArrayList<Chapter> chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "Truyện: " + this.getNameNovel() + "\nThể loại: "
                + this.getCategory() + "\n" + this.author.toSting()
                + "\nTình trạng: " + this.getStatus()
                + "\nTóm tắt: " + this.getIntroNovel();
    }
}
