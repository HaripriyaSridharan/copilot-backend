package org.github.copilot1.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import org.github.copilot1.models.User;
import org.github.copilot1.models.Vehicle;
import org.github.copilot1.repo.UserRepository;
import org.github.copilot1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveUser(String id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setGender(user.getGender());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setProfileImage(user.getProfileImage());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public String getUserFirstName(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(User::getFirstName).orElse(null);
    }

    @Override
    public String getUserIdByEmail(String email) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        return optionalUser.map(User::getId).orElse(null);
    }

    @Override
    public User getUser(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public List<Vehicle> getVehicleById(String id) {
        return Optional.ofNullable(userRepository.findById(id).orElse(null)).map(User::getVehicles).orElse(null);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        userRepository.findById(vehicle.getUserId()).ifPresent(user -> {
            List<Vehicle> vehicles = Optional.ofNullable(user.getVehicles()).orElse(new ArrayList<>());
            vehicles.add(vehicle);
            user.setVehicles(vehicles);
            userRepository.save(user);
        });
    }
}
