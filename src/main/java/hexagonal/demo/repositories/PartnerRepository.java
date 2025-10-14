package hexagonal.demo.repositories;


import hexagonal.demo.models.Partner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PartnerRepository extends CrudRepository<Partner, Long> {

    Optional<Partner> findByCnpj(String cnpj);

    Optional<Partner> findByEmail(String email);
}