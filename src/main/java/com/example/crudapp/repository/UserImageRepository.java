package com.example.crudapp.repository;

import com.example.crudapp.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserImageRepository extends JpaRepository<UserImage,Long> {

}
