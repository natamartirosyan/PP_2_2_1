package hiber;

import hiber.config.AppConfig;
import hiber.model.*;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Luka", "Modric", "lukam@rmcf.com");
      Car car1 = new Car("AUDI", 123);
      user1.setUserCar(car1);
      userService.add(user1);
      User user2 = new User("Sergio", "Ramos", "sergior@rmcf.com");
      Car car2 = new Car("BMW", 321);
      user2.setUserCar(car2);
      userService.add(user2);
      User user3 = new User("Karim", "Benzema", "kb9@rmcf.com");
      Car car3 = new Car("lamborghini", 999);
      user3.setUserCar(car3);
      userService.add(user3);
      User user4 = new User("Cristiano", "Ronaldo", "cr7@rmcf.com");
      Car car4 = new Car("Ferrari", 007);
      user4.setUserCar(car4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car_" +user.getUserCar());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("BMW", 321));

      context.close();
   }
}
