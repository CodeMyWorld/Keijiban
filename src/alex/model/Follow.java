package alex.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alex on 16-4-11.
 */
@Entity(name = "Follow")
@Table(name = "follow")
public class Follow implements Serializable{
    private static final long serialVersionUID = 1L;
    public Follow(){super();}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

    @Column(name="followid")
    private Integer followId;

    @Column(name="userid", updatable = false, insertable = false)
    private Integer userid;


    public Integer getUserid() {
        return userid;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }
}
