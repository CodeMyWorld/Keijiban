package alex.model;

/**
 * Created by alex on 16-5-2.
 */
public class Session {
    private String username;
    private String nickname;

    public Session(String username, String nickname){
        this.username = username;
        this.nickname = nickname;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
