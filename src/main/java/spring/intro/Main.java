package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {

        //ApplicationContext
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        //Add users
        userService.add(new User("Ivasyk1", "Telesyk", "telesyk@i.ua"));
        userService.add(new User("Olenka1", "Zmiyuchka", "olenka@i.ua"));
        userService.add(new User("Yaga1", "Baba", "yaga@i.ua"));

        //Get users
        userService.listUsers().forEach(System.out:: println);
    }
}
