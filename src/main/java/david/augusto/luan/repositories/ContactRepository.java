package david.augusto.luan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import david.augusto.luan.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {}
