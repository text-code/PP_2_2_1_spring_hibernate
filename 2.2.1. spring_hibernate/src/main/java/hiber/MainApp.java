package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


        User userWithCar5 = new User("User5", "Lastname5", "user5@mail.ru");
        userWithCar5.setCar(new Car("five", 5));
        userService.add(userWithCar5);

        User userWithCar6 = new User("User6", "Lastname6", "user6@mail.ru");
        userWithCar6.setCar(new Car("six", 6));
        userService.add(userWithCar6);

        User userWithCar7 = new User("User7", "Lastname7", "user7@mail.ru");
        userWithCar7.setCar(new Car("seven", 7));
        userService.add(userWithCar7);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println((user.getCar() != null) ? user.getCar() : "No Car");
            System.out.println();
        }

        System.out.println(userService.userSearch("six", 6));

        context.close();
    }
}
