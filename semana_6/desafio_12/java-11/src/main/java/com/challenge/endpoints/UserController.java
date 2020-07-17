package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.userService.findById(id).get();
    }


    @GetMapping(params = "accelerationName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findByAccelerationName(@RequestParam String accelerationName) {
        return new ResponseEntity<>(this.userService.findByAccelerationName(accelerationName), HttpStatus.OK);
    }


    @GetMapping(params = "companyId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findByUserId(@RequestParam Long companyId) {
        return new ResponseEntity<>(this.userService.findByCompanyId(companyId), HttpStatus.OK);
    }
}
