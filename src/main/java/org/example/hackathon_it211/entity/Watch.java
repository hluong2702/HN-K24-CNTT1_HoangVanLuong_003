package org.example.hackathon_it211.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "watches")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Watch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false)
    private MovementType movementType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

}
