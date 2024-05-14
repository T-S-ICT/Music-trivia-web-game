package sem6.individualproject.users.business.impl;

import sem6.individualproject.users.domain.Users;
import sem6.individualproject.users.persistence.entity.UsersEntity;

public class UsersConverter {
    private UsersConverter(){
    }

    public static Users convert(UsersEntity usersEntity){
        return Users.builder()
                .id(usersEntity.getId())
                .username(usersEntity.getUsername())
                .email(usersEntity.getEmail())
                .password(usersEntity.getPassword())
                .build();
    }
}
