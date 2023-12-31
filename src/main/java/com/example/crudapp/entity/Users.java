package com.example.crudapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users extends AbstractEntity{
    private String userName;
    private String password;
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.ALL)
    private UserImage userImage;
}
