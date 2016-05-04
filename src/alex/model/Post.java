package alex.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by alex on 16-3-23.
 */

@Entity(name="Post")
@Table(name="post")
public class Post implements Serializable{
    private static final long serialVersionUID = 1L;
    public Post(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="content", length=200)
    private String content;

    @Column(name="time")
    private Date time;

    @Column(name = "nickname")
    private String nickname;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

    @Column(name="userid", insertable = false, updatable = false)
    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    @Transient
    private String timeForDisplay;

    public String getTimeForDisplay() {
        return timeForDisplay;
    }
    public void setTimeForDisplay(String timeForDisplay) {
        this.timeForDisplay = timeForDisplay;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
