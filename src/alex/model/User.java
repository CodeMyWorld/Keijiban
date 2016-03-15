package alex.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	public User(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
	private Integer id;
	
	@Column(name="username", length=45)
	private String username;
	
	@Column(name="password", length=45)
	private String password;

    @ManyToOne
    @JoinColumn(name = "groupid")
    private Group group;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "username: " + this.username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
