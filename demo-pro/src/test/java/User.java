import lombok.Data;

@Data
public class User {
    public enum State {
        WaitForDownload,
        Succ,
        Fail,
        Bad,
        PART
    }

    Integer id;
    String  username;
    String  email;
    String  address;
    State   state;
}
