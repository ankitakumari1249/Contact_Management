package com.scm.contact.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.scm.contact.entities.Contact;
import com.scm.contact.entities.User;

@Service
public interface ContactService {
  // save contacts
  Contact save(Contact contact);

  // update contact
  Contact update(Contact contact);

  // get contacts
  List<Contact> getAll();

  // get contact by id

  Contact getById(String id);

  // delete contact

  void delete(String id);

  // search contact
  Page<Contact> searchByName(String nameKeyword, int size, int page, String sortBy, String order, User user);

  Page<Contact> searchByEmail(String emailKeyword, int size, int page, String sortBy, String order, User user);

  Page<Contact> searchByPhoneNumber(String phoneNumberKeyword, int size, int page, String sortBy, String order,
      User user);

  // get contacts by userId
  List<Contact> getByUserId(String userId);

  Page<Contact> getByUser(User user, int page, int size, String sortField, String sortDirection);

}