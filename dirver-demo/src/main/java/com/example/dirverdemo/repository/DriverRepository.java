package com.example.dirverdemo.repository;

import com.example.dirverdemo.domin.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author erfan
 * @since 12/23/23
 */
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
