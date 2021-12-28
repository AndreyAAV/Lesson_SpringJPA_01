package by.itclass.repositories;

import by.itclass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Аналог класса DAO
@Repository
public interface MyRepository extends JpaRepository<User, Integer> {
    //read...
    //find...
    //get...
//все это слова-синонимы select * .... users where id=1

    User findByName(String name);
    List<User> findByIdBetween(int low, int high);
    List<User> findByIdBetweenAndNameIsNotNull(int low, int high);
    List<User> findByIdBetweenOrNameLike(int low, int high, String regex);

    @Query(value = "select * from users", nativeQuery = true)
    List<User> getAllUsers();

}
