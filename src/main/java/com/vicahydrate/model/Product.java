package com.vicahydrate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "size_ml", nullable = false)
    private Integer sizeMl;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "features", columnDefinition = "text[]")
    private String[] features;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "in_stock")
    private Boolean inStock = true;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public String getSizeLabel() {
        if (sizeMl >= 1000) {
            int litres = sizeMl / 1000;
            return litres + "L";
        }
        return sizeMl + "ml";
    }
}
