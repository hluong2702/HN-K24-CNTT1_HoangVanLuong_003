package org.example.hackathon_it211.dto.request;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hackathon_it211.entity.MovementType;
import org.example.hackathon_it211.entity.Status;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchPatchRequestDTO {
    private String modelName;
    private String brand;

    @Min(value = 0, message = "Price phải lớn hơn 0")
    private Double price;

    private MovementType movementType;
    private Status status;
}
