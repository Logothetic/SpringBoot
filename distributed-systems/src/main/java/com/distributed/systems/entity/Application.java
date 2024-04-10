package com.distributed.systems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Application {
    @Column(nullable = false)
    private String applicantsAFM;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String state;

    @Column
    private String staffId;

    @Column(nullable = false)
    private Date applicationDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationId;
}
