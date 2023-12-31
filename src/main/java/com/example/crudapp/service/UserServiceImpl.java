package com.example.crudapp.service;

import com.example.crudapp.dto.ApiResponse;
import com.example.crudapp.dto.UserDto;
import com.example.crudapp.entity.UserImage;
import com.example.crudapp.entity.Users;
import com.example.crudapp.repository.UserImageRepository;
import com.example.crudapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserImageRepository userImageRepository;
    @Override
    public ApiResponse createUser(UserDto userDto) throws IOException {
        boolean b = userRepository.existsByUserName(userDto.getUserName());
        if (b)return new ApiResponse("exists userName",false);
        Users users=new Users();
        users.setUserName(userDto.getUserName());
        users.setPassword(userDto.getPassword());

        UserImage userImage=new UserImage();
        userImage.setOriginalName(userDto.getUserImage().getOriginalFilename());
        userImage.setContentType(userDto.getUserImage().getContentType());
        userImage.setImageByte(userDto.getUserImage().getBytes());
        userImageRepository.save(userImage);

        users.setUserImage(userImage);
        userRepository.save(users);
        return new ApiResponse("create User",true);
    }

    @Override
    public ApiResponse updateUser(Long id, UserDto userDto) throws IOException {
        Optional<Users> byId = userRepository.findById(id);
        boolean b = userRepository.existsByIdNotAndUserName(id,userDto.getUserName());
        if (byId.isEmpty()) return new ApiResponse("User Not Found",false);
        if (b)return new ApiResponse("exists userName",false);
        Users users=byId.get();
        users.setUserName(userDto.getUserName());
        users.setPassword(userDto.getPassword());

        UserImage userImage=byId.get().getUserImage();
        userImage.setOriginalName(userDto.getUserImage().getOriginalFilename());
        userImage.setContentType(userDto.getUserImage().getContentType());
        userImage.setImageByte(userDto.getUserImage().getBytes());
        userImageRepository.save(userImage);

        users.setUserImage(userImage);
        userRepository.save(users);
        return new ApiResponse("update User",true);
    }

    @Override
    public ApiResponse getIdUser(Long id) {
        Optional<Users> byId = userRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse("User Not Found",false);
        return new ApiResponse("user",true,byId);
    }

    @Override
    public ApiResponse getUsers() {
        List<Users> all = userRepository.findAll();
        if (all.isEmpty()) return new ApiResponse("Not Found Users",false);
        return new ApiResponse("All Users",true,all);
    }

    @Override
    public ApiResponse deleteIdUser(Long id) {
        Optional<Users> byId = userRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse("User Not Found",false);
        System.out.println(byId.get().getUserImage().getId());
//        userImageRepository.deleteById(byId.get().getUserImage().getId());
        userRepository.deleteById(id);
        return new ApiResponse("Deleted User",true);
    }

    @Override
    public ApiResponse deleteAllUsers() {
        userRepository.deleteAll();
        return new ApiResponse("Deleted All Users",true);
    }
}
