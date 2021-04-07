package za.co.infowarestudios.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import com.epsystems.billpaymentutils.entities.Sequence;
import org.springframework.stereotype.Repository;

import za.co.infowarestudios.entity.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, String> {

	Optional<Administrator> findByUserId(String userId);

}
