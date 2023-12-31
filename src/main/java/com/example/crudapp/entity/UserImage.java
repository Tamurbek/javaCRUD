package com.example.crudapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserImage extends AbstractEntity {
    private String originalName;
    private String contentType;
    private byte[] imageByte;
    @OneToOne(mappedBy = "userImage", optional = false)
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
