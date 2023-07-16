package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for managing contacts, companies, and statuses in the CRM application.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CrmService {

    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    /**
     * Retrieves all contacts from the repository.
     *
     * @param filterText A text filter used to search for contacts by first name or last name.
     * @return A list of contacts matching the filter text, or all contacts if the filter text is null or empty.
     */
    public List<Contact> findAllContacts(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        } else {
            return contactRepository.search(filterText);
        }
    }

    /**
     * Retrieves the total number of contacts in the repository.
     *
     * @return The total number of contacts.
     */
    public long countContacts() {
        return contactRepository.count();
    }

    /**
     * Deletes a contact from the repository.
     *
     * @param contact The contact to be deleted.
     */
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    /**
     * Saves a contact in the repository.
     *
     * @param contact The contact to be saved.
     */
    public void saveContact(Contact contact) {
        if (contact == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        contactRepository.save(contact);
    }

    /**
     * Retrieves all companies from the repository.
     *
     * @return A list of all companies.
     */
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    /**
     * Retrieves all statuses from the repository.
     *
     * @return A list of all statuses.
     */
    public List<Status> findAllStatuses(){
        return statusRepository.findAll();
    }

}
