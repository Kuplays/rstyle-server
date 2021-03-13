package com.kuplays.rstyle;

import com.kuplays.rstyle.entities.BookEntity;
import com.kuplays.rstyle.entities.UserEntity;
import com.kuplays.rstyle.repositories.BookRepository;
import com.kuplays.rstyle.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RstyleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RstyleApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(BookRepository bookRepository, UserRepository userRepository) {
        return (args) -> {
            userRepository.save(new UserEntity("reader", "admin"));
            bookRepository.save(new BookEntity("Властелин Колец", "Д. Толкин", 2005, "Книга"));
            bookRepository.save(new BookEntity("Зов Ктулху", "Г. Лавкрафт", 2000, "Аудиокнига"));
            bookRepository.save(new BookEntity("Опрокинутый мир", "К. Прист", 2020, "Электронная книга"));
            bookRepository.save(new BookEntity("Страж небес", "У. Крюгер", 1991, "Книга"));
            bookRepository.save(new BookEntity("Без следа", "Л. Чайлд", 2001, "Электронная книга"));
        };
    }
}
