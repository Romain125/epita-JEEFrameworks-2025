package epita.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private Notifier notifier;
    private Tracer tracer;

    @Autowired
    public NotificationService(Notifier notifier, Tracer tracer) {
        this.notifier = notifier;
        this.tracer = tracer;
    }

    public void notifyUser(User user, String message){
        notifier.notify(user, message);
        tracer.trace("User "+ user.getName()+" has been notified");
    }
}
