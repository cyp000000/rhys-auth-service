package za.co.infowarestudios.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.infowarestudios.entity.User;

/**
 * Created by Jomo Lumina on 2018/06/05.
 */
public interface UserRepository extends CrudRepository<User,Long> {

	User findByUserId(String userId);

}
