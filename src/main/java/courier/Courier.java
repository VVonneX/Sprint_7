package courier;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private Integer code;
    private String message;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public Courier(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Courier (Integer id) {
        this.id = id;
    }
}
