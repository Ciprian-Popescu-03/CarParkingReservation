package com.carparking.reservation.service;

import com.carparking.reservation.entity.ContactMessage;
import com.carparking.reservation.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public void saveMessage(String name, String email, String message) {
        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setName(name);
        contactMessage.setEmail(email);
        contactMessage.setMessage(message);
        contactMessageRepository.save(contactMessage);
    }
}
