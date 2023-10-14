package edu.miu.waa.lab8.service;

import edu.miu.waa.lab8.dto.RegistrationRequest;
import edu.miu.waa.lab8.model.User;

public interface UserService {

    public User save(RegistrationRequest reg);
}
