package de.neuefische.backend.service;

import de.neuefische.backend.model.TravelUser;
import de.neuefische.backend.repo.TravelUserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class AppUsersDetailService implements UserDetailsService {

    private final TravelUserRepo travelUserRepo;
    public AppUsersDetailService(TravelUserRepo travelUserRepo) {
        this.travelUserRepo = travelUserRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TravelUser user = travelUserRepo.findById(username)
                .orElse(null);
        if (user == null) {
            return null;
        }
        return new User(user.getUsername(), user.getPasswordHash(), Collections.emptyList());
    }

    public String getEmailByUsername(String username){
        TravelUser user = travelUserRepo.findById(username)
                .orElse(null);
        if (user == null) {
            return null;
        }
        return user.getEmail();
    }

}
