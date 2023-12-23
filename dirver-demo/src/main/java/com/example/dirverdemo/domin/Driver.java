package com.example.dirverdemo.domin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

/**
 * @author erfan
 * @since 12/23/23
 */
@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString
public class Driver extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driverSeq")
    @SequenceGenerator(name = "driverSeq", sequenceName = "driver_seq", allocationSize = 1)
    private int id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String age;

    @JsonIgnore
    public boolean isNew() {
        return getId() == 0;
    }
}
