package MVC;

import java.time.LocalDateTime;

public class Dialog {
    String user;
    LocalDateTime time;
    String body;

    public Dialog(String user, LocalDateTime time, String body) {
        this.user = user;
        this.time = time;
        this.body = body;
    }

    public Dialog() {
        this.user = "test name";
        this.time = LocalDateTime.now();
        this.body = "test message\nsecond line of test message";
    }
}
