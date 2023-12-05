package com.note_master.service;

import com.note_master.entity.Reminder;
import com.note_master.entity.Utilizator;
import com.note_master.repository.ReminderRepository;
import com.note_master.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final UtilizatorRepository utilizatorRepository;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository, UtilizatorRepository utilizatorRepository) {
        this.reminderRepository = reminderRepository;
        this.utilizatorRepository = utilizatorRepository;
    }

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public Reminder getReminderById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }

    public Reminder saveReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }

    public List<Reminder> getRemindersForUser(Long userId) {
        Utilizator utilizator = utilizatorRepository.findById(userId).orElse(null);
        return (utilizator != null) ? utilizator.getReminders() : List.of();
    }

    public Reminder addReminderForUser(Long userId, Reminder reminder) {
        Utilizator utilizator = utilizatorRepository.findById(userId).orElse(null);
        if (utilizator != null) {
            utilizator.addReminder(reminder); // Adăugă reminder-ul în lista utilizatorului
            reminder.setUtilizator(utilizator);
            utilizatorRepository.save(utilizator); // Salvează utilizatorul cu noul reminder
            return reminder;
        }
        return null;
    }


    public void deleteReminderForUser(Long userId, Long reminderId) {
        Utilizator utilizator = utilizatorRepository.findById(userId).orElse(null);
        Reminder reminder = reminderRepository.findById(reminderId).orElse(null);
        if (utilizator != null && reminder != null && utilizator.getReminders().contains(reminder)) {
            reminderRepository.deleteById(reminderId);
        }
    }

    public void JPATestClear() {
        reminderRepository.deleteAll();
    }
}
