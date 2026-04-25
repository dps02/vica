package com.vicahydrate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "inquiries")
@Data
@NoArgsConstructor
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String phone;

    @Column(columnDefinition = "text", nullable = false)
    private String message;

    @Column(nullable = false)
    private String status = "new";

    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}
