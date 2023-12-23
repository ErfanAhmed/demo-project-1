package com.example.dirverdemo.service;

import com.example.dirverdemo.domin.Driver;
import com.example.dirverdemo.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * @author erfan
 * @since 12/23/23
 */
@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public Driver findById(int id) {
        return driverRepository.findById(id).get();
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Driver save(Driver driver) {
        if (driver.isNew()) {
            driver.setCreated(LocalDateTime.now());
        } else {
            Driver existingDriver = findById(driver.getId());

            ofNullable(driver.getName()).ifPresent(existingDriver::setName);
            ofNullable(driver.getAge()).ifPresent(existingDriver::setAge);
            driver.setUpdated(LocalDateTime.now());
        }

        return driverRepository.save(driver);
    }

    public void delete(int id) {
        Driver driver = driverRepository.getReferenceById(id);

        driverRepository.delete(driver);
    }
}
