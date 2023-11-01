package com.note_master.demo3;

import com.note_master.entity.NoteEntity;
import com.note_master.entity.UserEntity;
import com.note_master.repository.NoteRepository;
import com.note_master.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class UserEntityTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testUserEntity() {

        UserEntity user = new UserEntity();
        UserEntity user1 = new UserEntity();
        UserEntity user2= new UserEntity();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user1.setUsername("User1");
        user1.setPassword("parola1");

        user2.setUsername("User2");
        user2.setPassword("parola2");

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);

        int user_id = userRepository.findByUsername("User1").getId();
        System.out.println(user_id);

        UserEntity savedUser = userRepository.findByUsername("john_doe");

        assertEquals("john@example.com", savedUser.getEmail());

        userRepository.delete(savedUser);
        assertEquals(2, userRepository.count());
    }
}

@DataJpaTest
class NoteEntityTest {
    @Autowired
    private NoteRepository noteRepository; //
    @Test
    void testNoteEntity() {

        NoteEntity note = new NoteEntity();
        note.setTitle("My Note");
        note.setContent("This is the content of my note.");
        note.setUserId(123);

        noteRepository.save(note);

        NoteEntity savedNote = noteRepository.findByTitle(note.getTitle());
        assertEquals("My Note", savedNote.getTitle());

        noteRepository.delete(savedNote);
        assertEquals(0, noteRepository.count());
    }
}
