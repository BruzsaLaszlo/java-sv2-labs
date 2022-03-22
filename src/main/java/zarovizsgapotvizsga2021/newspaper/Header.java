package zarovizsgapotvizsga2021.newspaper;

public class Header {

    private String content;

    private int level;

    public Header(String content, int level) {
        this.content = content;
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public int getLevel() {
        return level;
    }
}
