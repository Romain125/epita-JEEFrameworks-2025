package epita.tp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("MAIL")
public class EmailNotifier implements Notifier {

    public void notify(User user, String message) {
        System.out.println("Sending mail to"+ user.getEmail()+"...");
    }
}
