package in.raj.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.raj.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
