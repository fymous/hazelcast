package com.example.hazelcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.hazelcast.entity.User;
import com.example.hazelcast.repository.UserDAO;

@Component
public class DataLoader implements ApplicationRunner {

    private UserDAO userRepository;

    @Autowired
    public DataLoader(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        userRepository.save(new User(1, "ola", "1111"));
        userRepository.save(new User(2, "uber", "2222"));
        userRepository.save(new User(3, "lyft", "3333"));

}
}