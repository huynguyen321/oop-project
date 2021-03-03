package Framework;

public class Chapter{

    private int numChap;
    private String timeUpdate;
    private String content;

    public Chapter() {
    }

    public Chapter(int numChap, String timeUpdate, String content) {
        this.setNumChap(numChap);
        this.setTimeUpdate(timeUpdate);
        this.setContent(content);
    }

    public int getNumChap() {
        return this.numChap;
    }

    public void setNumChap(int numChap) {
        if (numChap > 0) {
            this.numChap = numChap;
        }
    }

    public String getTimeUpdate() {
        return this.timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
