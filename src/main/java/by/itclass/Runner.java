package by.itclass;

import by.itclass.config.JPAConfig;
import by.itclass.entity.User;
import by.itclass.repositories.MyRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Runner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
        MyRepository repository = context.getBean(MyRepository.class);

        User user = repository.findById(1).get();//select * from users where id=1
        //System.out.println(user);

        repository.findByName("Alex");
        //System.out.println(user);

        List<User> users = repository.findByIdBetween(2, 6);
        System.out.println(users);

        users = repository.findByIdBetweenAndNameIsNotNull(2, 10);
        System.out.println(users);

        users = repository.findByIdBetweenOrNameLike(4, 10, "user%");
        System.out.println(users);

        users = repository.getAllUsers();
        System.out.println(users);

    }
}
