package epita.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        NotificationService notificationService = context.getBean("notificationService", NotificationService.class);
        User romain = new User("Romain", "romain.noel125@gmail.com");
        User romain2 = new User("Romain2", "romain.noel126@gmail.com");
        notificationService.notifyUser(romain, "Hello !");
        notificationService.notifyUser(romain2, "Hello !");
    }
}
