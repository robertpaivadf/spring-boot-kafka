package com.analytics.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="brand_analytics")
@Data
@NoArgsConstructor
public class BrandAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand; //200 Ford, 100 Toyota, 100 Fiat

    private  Long posts;



}
