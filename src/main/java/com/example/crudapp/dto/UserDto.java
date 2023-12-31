package com.example.crudapp.dto;

import com.example.crudapp.entity.UserImage;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserDto {
    private String userName;
    private String password;
    private MultipartFile userImage;
}
