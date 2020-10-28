package za.co.infowarestudios.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.infowarestudios.entity.Role;

/**
 * Created by Jomo Lumina on 2018/06/05.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {
	Role findByDescription(String description);
}
