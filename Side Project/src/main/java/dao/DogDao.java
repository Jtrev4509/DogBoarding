package dao;

import model.Dog;

import java.util.List;

public interface DogDao {

    Dog getDog(int dogId);
    List<Dog> getDogsByOwnerId(int ownerId);
    void createDog(int ownerId, String dogName, String dogBreed, int dogAge, int dogWeight, String dogSex);
    void updateDog(String dogName, int dogAge, int dogWeight);
    void deleteDog(int dogId);
}
