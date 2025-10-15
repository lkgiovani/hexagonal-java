package hexagonal.infrastructure.repositories;

import hexagonal.application.domain.partner.Partner;
import hexagonal.application.domain.partner.PartnerId;
import hexagonal.application.domain.person.Cnpj;
import hexagonal.application.domain.person.Email;
import hexagonal.application.repositories.PartnerRepository;
import hexagonal.infrastructure.db.entities.PartnerEntity;
import hexagonal.infrastructure.db.repositories.PartnerDbaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

// Interface Adapter
@Component
public class PartnerDatabaseRepository implements PartnerRepository {

    private final PartnerDbaRepository partnerDbRepository;

    public PartnerDatabaseRepository(final PartnerDbaRepository partnerDbRepository) {
        this.partnerDbRepository = Objects.requireNonNull(partnerDbRepository);
    }

    @Override
    public Optional<Partner> partnerOfId(final PartnerId anId) {
        Objects.requireNonNull(anId, "id cannot be null");
        return this.partnerDbRepository.findById(UUID.fromString(anId.value()))
                .map(PartnerEntity::toPartner);
    }

    @Override
    public Optional<Partner> partnerOfCNPJ(final Cnpj cnpj) {
        Objects.requireNonNull(cnpj, "Cnpj cannot be null");
        return this.partnerDbRepository.findByCnpj(cnpj.value())
                .map(PartnerEntity::toPartner);
    }

    @Override
    public Optional<Partner> partnerOfEmail(final Email email) {
        Objects.requireNonNull(email, "Email cannot be null");
        return this.partnerDbRepository.findByEmail(email.value())
                .map(PartnerEntity::toPartner);
    }

    @Override
    @Transactional
    public Partner create(final Partner partner) {
        return this.partnerDbRepository.save(PartnerEntity.of(partner))
                .toPartner();
    }

    @Override
    @Transactional
    public Partner update(Partner partner) {
        return this.partnerDbRepository.save(PartnerEntity.of(partner))
                .toPartner();
    }

    @Override
    public void deleteAll() {
        this.partnerDbRepository.deleteAll();
    }
}
