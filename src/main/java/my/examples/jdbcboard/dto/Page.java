package my.examples.jdbcboard.dto;

public class Page {
    int count;
    int startnum;
    int lastnum;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLastnum() {
        return lastnum;
    }

    public void setLastnum(int lastnum) {
        this.lastnum = lastnum;
    }

    public int getStartnum() {
        return startnum;
    }

    public void setStartnum(int startnum) {
        this.startnum = startnum;
    }
}
