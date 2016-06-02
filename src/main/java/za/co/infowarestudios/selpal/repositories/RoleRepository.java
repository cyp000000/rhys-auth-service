package za.co.infowarestudios.selpal.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.infowarestudios.selpal.entity.Role;

/**
 * Created by chrismipi on 2015/12/23.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {
	Role findByRoleName(String roleName);
}
