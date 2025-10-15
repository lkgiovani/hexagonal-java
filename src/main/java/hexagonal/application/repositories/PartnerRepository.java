package hexagonal.application.repositories;

import hexagonal.application.domain.partner.Partner;
import hexagonal.application.domain.partner.PartnerId;
import hexagonal.application.domain.person.Cnpj;
import hexagonal.application.domain.person.Email;

import java.util.Optional;

public interface PartnerRepository {

    Optional<Partner> partnerOfId(PartnerId anId);

    Optional<Partner> partnerOfCNPJ(Cnpj cnpj);

    Optional<Partner> partnerOfEmail(Email email);

    Partner create(Partner partner);

    Partner update(Partner partner);

    void deleteAll();
}
