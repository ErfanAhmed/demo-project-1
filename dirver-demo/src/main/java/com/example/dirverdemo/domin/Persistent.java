package com.example.dirverdemo.domin;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * @author erfan
 * @since 12/23/23
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Persistent {

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    @Version
    private int version;
}
