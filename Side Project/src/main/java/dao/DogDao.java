package dao;

import model.Dog;

import java.util.List;

public interface DogDao {

    Dog getDog(int dogId);
    List<Dog> getDogsByOwnerName(int ownerName);
    Dog createDog(Dog dog);
    void updateDog(Dog dog);
    void deleteDog(int dogId);
}
