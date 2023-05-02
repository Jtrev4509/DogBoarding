package dao;

import model.Owner;

import java.util.List;

public interface OwnerDao {

    Owner getOwner(int ownerId);

    List<Owner> getOwners();

    void createOwner(String owner);

    void deleteOwner(int ownerId);
}
