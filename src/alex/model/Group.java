package alex.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by alex on 16-1-13.
 */
@Entity(name = "Group")
@Table(name = "department")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;
    public Group(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer groupId;

    @Column(name = "groupname", length = 45)
    private String groupName;

    @OneToMany(mappedBy = "group")
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
