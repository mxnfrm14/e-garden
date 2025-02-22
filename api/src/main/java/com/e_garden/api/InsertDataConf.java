package com.e_garden.api;

import com.e_garden.api.user.Roles;
import com.e_garden.api.user.User;
import com.e_garden.api.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class InsertDataConf {
    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            User gabin = new User("admind@egarden.fr", "admin");
            gabin.setSurname("admin");
            gabin.setName("admin");
            gabin.setClassName("ING");
            gabin.setGroupNumber(1);
            gabin.setRole(String.valueOf(Roles.ADMINISTRATEUR));

            userService.saveUsers(List.of(gabin));
        };
    }
}
