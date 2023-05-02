package dao;

import model.Dog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDogDao implements DogDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDogDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Dog getDog(int dogId) {
        Dog dog = new Dog();
        dog.setDogId(dogId);
        String sql = "SELECT owner_name, dog_name, dog_breed, dog_age, dog_weight, dog_sex " +
                "FROM dog " +
                "JOIN dog_owner ON dog.dog_id = dog_owner.dog_id " +
                "JOIN owner_info ON owner_info.owner_id = dog_owner.owner_id " +
                "WHERE dog.dog_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dogId);
        if(results.next()){
            dog = mapRowToDog(results);
        } else {
            return null;
        }
        return dog;
    }

    @Override
    public List<Dog> getDogsByOwnerId(int ownerId) {
        List<Dog> listOfDogs = new ArrayList<>();
        String sql = "SELECT * FROM dog WHERE owner_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ownerId);
        while(results.next()){
            Dog dog = mapRowToDog(results);
            listOfDogs.add(dog);
        }
        return listOfDogs;
    }

    @Override
    public void createDog(int ownerId, String dogName, String dogBreed, int dogAge, int dogWeight, String dogSex) {
        String sql = "INSERT INTO dog (owner_id, dog_name, dog_breed, dog_age, dog_weight, dog_sex) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, ownerId, dogName, dogBreed, dogAge, dogWeight, dogSex);
    }

    @Override
    public void updateDog(String dogName, int dogAge, int dogWeight) {
        String sql = "UPDATE dog SET dog_age = ?, dog_weight = ? WHERE dog_name = ?;";
        jdbcTemplate.update(sql, dogAge, dogWeight, dogName);
    }

    @Override
    public void deleteDog(int dogId) {
        String sql = "DELETE FROM dog WHERE dog_id = ?;";
        jdbcTemplate.update(sql, dogId);
    }

    private Dog mapRowToDog(SqlRowSet results){
        Dog dog = new Dog();
        dog.setDogId(results.getInt("dog_id"));
        dog.setOwnerId(results.getInt("owner_id"));
        dog.setDogName(results.getString("dog_name"));
        dog.setDogBreed(results.getString("dog_breed"));
        dog.setDogAge(results.getInt("dog_age"));
        dog.setDogWeight(results.getInt("dog_weight"));
        dog.setDogMOrF(results.getString("dog_sex"));
        return dog;
    }
}
