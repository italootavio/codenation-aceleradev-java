package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUserByAccelerationIdOrUserId(
            @RequestParam(name = "accelerationName", required = false) Optional<String> accelerationName,
            @RequestParam(name = "companyId", required = false) Optional<Long> companyId) {
        if (accelerationName.isPresent()) {
            return ResponseEntity.ok(userService.findByAccelerationName(accelerationName.get()));
        } else if (companyId.isPresent()) {
            return ResponseEntity.ok(userService.findByCompanyId(companyId.get()));
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
