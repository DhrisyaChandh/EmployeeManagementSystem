package com.spring.ems.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.ems.entities.Contact;

/**
 * 
 * @author Dhrisya Chandran
 * @since 08.10.2021
 *
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{


}
