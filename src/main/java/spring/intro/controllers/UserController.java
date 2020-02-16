package spring.intro.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String inject() {
        User newUser1 = new User();
        newUser1.setFirstName("Ivan");
        newUser1.setLastName("Ivanenko");
        newUser1.setEmail("ivan@i.ua");
        userService.add(newUser1);

        User newUser2 = new User();
        newUser2.setFirstName("Petro");
        newUser2.setLastName("Petrenko");
        newUser2.setEmail("petro@i.ua");
        userService.add(newUser2);

        User newUser3 = new User();
        newUser3.setFirstName("Pavlo");
        newUser3.setLastName("Pavlenko");
        newUser3.setEmail("pavlo@i.ua");
        userService.add(newUser3);

        User newUser4 = new User();
        newUser4.setFirstName("Vasyl");
        newUser4.setLastName("Vasylenko");
        newUser4.setEmail("vasyl@i.ua");
        userService.add(newUser4);

        return "Users are injected successfully";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        UserResponseDto dto = new UserResponseDto();
        User user = userService.get(userId);
        dto.setName(user.getFirstName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> list = new ArrayList<>();
        userService.listUsers().forEach(u -> {
            UserResponseDto dto = new UserResponseDto();
            dto.setName(u.getFirstName());
            dto.setEmail(u.getEmail());
            list.add(dto);
        });
        return list;
    }
}
