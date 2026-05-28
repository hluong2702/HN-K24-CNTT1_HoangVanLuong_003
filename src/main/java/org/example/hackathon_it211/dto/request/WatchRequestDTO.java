package org.example.hackathon_it211.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class WatchRequestDTO {
    @NotBlank(message = "Model không được để trống")
    private String modelName;

    @NotBlank(message = "Brand không được để trống")
    private String brand;

    @NotNull(message = "Price không được để trống")
    @Min(value = 0, message = "Price phải lớn hơn 0")
    private Double price;

    @NotNull(message = "Movement type không được để trống")
    private MovementType movementType;

    @NotNull(message = "Status không được để trống")
    private Status status;

}
