package io.fantasy.bank.backend.rest.exception.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FantasyError {
    @Schema(description = "Code", example = "FB_XXX")
    private String code;
    @Schema(description = "Path", example = "/api")
    private String path;
    @Schema(description = "Method", example = "METHOD")
    private HttpMethod method;
    @Schema(description = "Time", example = "20-12-2023 20:30:40")
    private String time;
    @Schema(description = "Status", example = "STATUS")
    private HttpStatus status;
}
