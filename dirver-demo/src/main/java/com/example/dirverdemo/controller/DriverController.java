package com.example.dirverdemo.controller;

import com.example.dirverdemo.domin.Driver;
import com.example.dirverdemo.service.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.dirverdemo.util.ApiResponseUtil.successResponse;
import static com.example.dirverdemo.util.ApiResponseUtil.validationErrorResponse;

/**
 * @author erfan
 * @since 12/23/23
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/drivers")
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    public ResponseEntity<List<Driver>> drivers() {
        return successResponse(driverService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        return successResponse(driverService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Driver driverDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return validationErrorResponse(bindingResult);
        }

        Driver driver = driverService.save(driverDto);

        log.info("Driver saved successfully");

        return successResponse(driver);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Driver driverDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return validationErrorResponse(bindingResult);
        }

        Driver driver = driverService.save(driverDto);

        log.info("Driver {} info updated", driver.getName());

        return successResponse(driver);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Driver driver) {
        driverService.delete(driver.getId());

        log.info("Driver {} deleted", driver.getName());

        return successResponse("Driver Deleted");
    }
}
