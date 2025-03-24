package epita.tp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("SMS")
public class SmsNotifier implements Notifier{

    public void notify(User user, String message) {
        System.out.println("Sending sms to"+ user.getName()+"...");
    }
}
