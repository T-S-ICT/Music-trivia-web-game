package sem6.IndividualProject.MusicTrivia.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem6.IndividualProject.MusicTrivia.business.UsersService;
import sem6.IndividualProject.MusicTrivia.domain.CreateUsersRequest;
import sem6.IndividualProject.MusicTrivia.domain.CreateUsersResponse;
import sem6.IndividualProject.MusicTrivia.domain.GetUsersResponse;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<CreateUsersResponse> createUsers(@RequestBody @Valid CreateUsersRequest request){
        CreateUsersResponse response = usersService.createUsers(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<GetUsersResponse> getUsers(){
        return ResponseEntity.ok(usersService.getUsers());
    }
}
