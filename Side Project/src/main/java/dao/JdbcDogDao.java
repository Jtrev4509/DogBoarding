package dao;

import model.Dog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcDogDao implements DogDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDogDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Dog getDog(int dogId) {
        Dog dog = new Dog();
        dog.setDogId(dogId);
        //join dog_owner table to get the owner name from the owner id
        String sql = "SELECT owner_name, dog_name, dog_breed, dog_age, dog_weight, dog_sex " +
                "JOIN dog_owner ON dog.dog_id = dog_owner.dog_id " +
                "FROM dog WHERE dog_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dogId);
        if(results.next()){
            dog = mapRowToDog(results);
        } else {
            return null;
        }
        return dog;
    }

    @Override
    public List<Dog> getDogsByOwnerName(int ownerId) {

        return null;
    }

    @Override
    public Dog createDog(Dog dog) {
        return null;
    }

    @Override
    public void updateDog(Dog dog) {

    }

    @Override
    public void deleteDog(int dogId) {

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
