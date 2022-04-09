package ru.itmo.kotiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.kotiki.Generator;
import ru.itmo.kotiki.dto.OwnerDto;
import ru.itmo.kotiki.model.Owner;
import ru.itmo.kotiki.service.OwnerServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerServiceImpl ownerService;

    private final Generator generator = new Generator();

    @GetMapping("/get/{id}")
    public OwnerDto getOwnerById(@PathVariable int id) {
        return generator.ownerToOwnerDto(ownerService.findOwner(id));
    }

    @GetMapping("/get")
    public List<OwnerDto> getOwners() {
        List<OwnerDto> ownersDto = new ArrayList<>();
        for (Owner owner : ownerService.findAllOwners()) {
            ownersDto.add(generator.ownerToOwnerDto(owner));
        }

        return ownersDto;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOwner(@RequestBody OwnerDto ownerDto) {
        Owner owner = generator.dtoOwnerToOwner(ownerDto);
        ownerService.saveOwner(owner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOwner(@RequestBody OwnerDto ownerDto) {
        Owner owner = generator.dtoOwnerToOwner(ownerDto);
        ownerService.saveOwner(owner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOwner(@PathVariable int id) {
        ownerService.deleteOwner(ownerService.findOwner(id));
    }
}