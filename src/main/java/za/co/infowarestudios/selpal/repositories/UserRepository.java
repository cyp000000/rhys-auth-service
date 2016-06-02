package za.co.infowarestudios.selpal.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.infowarestudios.selpal.entity.User;

/**
 * Created by victorrikhotso on 2016/03/08.
 */
public interface UserRepository extends CrudRepository<User,Long> {

	public User findUserByUserId(String userId);

}
