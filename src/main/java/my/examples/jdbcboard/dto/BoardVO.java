package my.examples.jdbcboard.dto;

import java.util.Date;

/*

id | title  | writer | content        | regdate             | read_count | groupno | grpord | depth
 */
public class BoardVO {
    private Long id;
    private Long userId;
    private String title;
    private String nickname;
    private String content;
    private Date regdate;
    private int readcount;
    private int groupno;
    private int grpord;
    private int depth;

    public BoardVO(){
        this.regdate = new Date();
        this.readcount = 0;
    }
    public BoardVO(String title, String nickname, String content, Date regdate, int readcount, int groupno, int grpord, int depth){
        this.title = title;
        this.nickname = nickname;
        this.content = content;
        this.regdate = regdate;
        this.readcount = readcount;
        this.groupno = groupno;
        this.grpord = grpord;
        this.depth = depth;
    }

    public BoardVO(Long id, String title, String nickname, Date regdate, int readcount, int groupno, int grpord, int depth){
        this.id = id;
        this.title = title;
        this.nickname = nickname;
        this.regdate = regdate;
        this.readcount = readcount;
        this.groupno = groupno;
        this.grpord = grpord;
        this.depth = depth;
    }

    public BoardVO(Long id, String title, String nickname, String content, Date regdate, int readcount, int groupno, int grpord, int depth){
        this.id = id;
        this.title = title;
        this.nickname = nickname;
        this.content = content;
        this.regdate = regdate;
        this.readcount = readcount;
        this.groupno = groupno;
        this.grpord = grpord;
        this.depth = depth;
    }

    public BoardVO(String title, String content, String nickname){
        this();
        this.title = title;
        this.content = content;
        this.nickname = nickname;
    }

    public BoardVO(Long userId, String title, String nickname, String content) {
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setUserId(String userId) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public int getGroupno() {
        return groupno;
    }

    public void setGroupno(int groupno) {
        this.groupno = groupno;
    }

    public int getGrpord() {
        return grpord;
    }

    public void setGrpord(int grpord) {
        this.grpord = grpord;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", readcount=" + readcount +
                ", groupno=" + groupno +
                ", grpord=" + grpord +
                ", depth=" + depth +
                '}';
    }
}

