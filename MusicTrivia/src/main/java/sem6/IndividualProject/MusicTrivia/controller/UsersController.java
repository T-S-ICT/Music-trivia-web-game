package sem6.IndividualProject.MusicTrivia.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem6.IndividualProject.MusicTrivia.business.UsersService;
import sem6.IndividualProject.MusicTrivia.domain.users.CreateUsersRequest;
import sem6.IndividualProject.MusicTrivia.domain.users.CreateUsersResponse;
import sem6.IndividualProject.MusicTrivia.domain.users.GetAllUsersResponse;
import sem6.IndividualProject.MusicTrivia.domain.users.Users;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<CreateUsersResponse> createUser(@RequestBody @Valid CreateUsersRequest request){
        CreateUsersResponse response = usersService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<GetAllUsersResponse> getAllUser(){
        return ResponseEntity.ok(usersService.getAllUser());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getUser(@PathVariable(value = "id") final long id){
        final Optional<Users> userOptional = usersService.getUser(id);
        if(userOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userOptional.get());
    }
}
