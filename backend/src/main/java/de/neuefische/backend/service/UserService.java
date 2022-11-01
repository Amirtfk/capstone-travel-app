package de.neuefische.backend.service;

import de.neuefische.backend.model.CreateUserDto;
import de.neuefische.backend.model.TravelUser;
import de.neuefische.backend.repo.TravelUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private TravelUserRepo travelUserRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(TravelUserRepo travelUserRepo, PasswordEncoder passwordEncoder) {
        this.travelUserRepo = travelUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(CreateUserDto createUserDto) {


       String hashedPassword = passwordEncoder.encode(createUserDto.getPassword());


       TravelUser travelUser = new TravelUser();
       travelUser.setUsername(createUserDto.getUsername());
       travelUser.setPasswordHash(hashedPassword);
       travelUser.setEmail(createUserDto.getEmail());


       return travelUserRepo.save(travelUser).getUsername();
    }
}
