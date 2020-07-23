package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> getAccelerationById(@PathVariable("id") Long id){
        Optional<Acceleration> userOptional = accelerationService.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Acceleration>> getAccelerationByCompanyId(
            @RequestParam(name = "companyId") Long companyId){
        return ResponseEntity.ok(accelerationService.findByCompanyId(companyId));
    }

}
