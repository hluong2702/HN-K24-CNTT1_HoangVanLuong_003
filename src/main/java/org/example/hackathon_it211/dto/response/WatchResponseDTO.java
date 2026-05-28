package org.example.hackathon_it211.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.hackathon_it211.entity.MovementType;
import org.example.hackathon_it211.entity.Status;


@Getter
@Setter
@Builder
public class WatchResponseDTO {
    private Long id;
    private String modelName;
    private String brand;
    private Double price;
    private MovementType movementType;
    private Status status;

}
