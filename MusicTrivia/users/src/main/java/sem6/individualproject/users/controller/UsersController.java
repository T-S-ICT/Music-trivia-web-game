package sem6.individualproject.users.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem6.individualproject.users.business.UsersService;
import sem6.individualproject.users.domain.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<CreateUsersResponse> signUp(@RequestBody @Valid CreateUsersRequest request){
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

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") long id,
                                           @RequestBody @Valid UpdateUsersRequest request){
        request.setId(id);
        usersService.updateUser(request);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<String> changePassword(@PathVariable("id") long id,
                                           @RequestBody @Valid UpdatePasswordRequest request){
        request.setId(id);
        String response = usersService.updatePassword(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
