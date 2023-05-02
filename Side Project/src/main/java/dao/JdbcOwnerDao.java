package dao;

import model.Owner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOwnerDao implements OwnerDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcOwnerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Owner getOwner(int ownerId) {
        Owner owner = new Owner();
        owner.setOwnerId(ownerId);
        String sql = "SELECT owner_name FROM owner_info WHERE owner_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ownerId);
        if (results.next()) {
            owner = mapRowToOwner(results);
        } else {
            return null;
        }
        return owner;
    }


    @Override
    public List<Owner> getOwners() {
        List<Owner> owners = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT owner_id, owner_name FROM owner_info;");
        while(results.next()){
            owners.add(mapRowToOwner(results));
        }
        return owners;
    }

    @Override
    public void createOwner(String ownerName){
        String sql = "INSERT INTO owner_info (owner_name) " +
                "VALUES (?);";
       jdbcTemplate.update(sql, ownerName);

    }

    @Override
    public void deleteOwner(int ownerId){
        String sql = "DELETE FROM dog_owner WHERE owner_id = ?;" +
                "DELETE FROM owner_info WHERE owner_id = ?;";
        jdbcTemplate.update(sql, ownerId, ownerId);
    }

    private Owner mapRowToOwner(SqlRowSet results){
        Owner owner = new Owner();
        owner.setOwnerId(results.getInt("owner_id"));
        owner.setOwnerName(results.getString("owner_name"));
        return owner;
    }
}
