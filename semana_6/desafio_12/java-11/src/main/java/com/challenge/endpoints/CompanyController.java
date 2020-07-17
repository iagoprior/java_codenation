package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable("id") Long id) {
        return this.companyService.findById(id);

    }



    @GetMapping(params = "accelerationId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> findByAccelerationId(@RequestParam Long accelerationId) {
        return new ResponseEntity<>(this.companyService.findByAccelerationId(accelerationId), HttpStatus.OK);
    }


    @GetMapping(params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> findByUserId(@RequestParam Long userId) {
        return new ResponseEntity<>(this.companyService.findByUserId(userId), HttpStatus.OK);
    }
}
