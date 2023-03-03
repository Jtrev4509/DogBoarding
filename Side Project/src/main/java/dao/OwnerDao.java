package dao;

import model.Owner;

import java.util.List;

public interface OwnerDao {

    Owner getOwner(int ownerId);

    List<Owner> getOwners();

    Owner createOwner(Owner newOwner);

    void deleteOwner(int ownerId);
}
