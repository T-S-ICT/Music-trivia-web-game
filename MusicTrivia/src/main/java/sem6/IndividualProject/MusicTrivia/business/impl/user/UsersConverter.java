package sem6.IndividualProject.MusicTrivia.business.impl.user;

import sem6.IndividualProject.MusicTrivia.domain.users.Users;
import sem6.IndividualProject.MusicTrivia.persistence.entity.UsersEntity;

public class UsersConverter {
    private UsersConverter(){
    }

    public static Users convert(UsersEntity usersEntity){
        return Users.builder()
                .id(usersEntity.getId())
                .username(usersEntity.getUsername())
                .build();
    }
}
