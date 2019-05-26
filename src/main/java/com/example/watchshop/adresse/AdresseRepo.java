package com.example.watchshop.adresse;
import com.example.watchshop.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepo extends CrudRepository<Adresse, Integer> {
    /**
     * @param user
     * @return the found address of the User
     */
    Adresse findAdresseByUser(User user);

    /**
     * @param user
     * @return the deleted address
     */
    Adresse deleteAdresseByUser(User user);

}
