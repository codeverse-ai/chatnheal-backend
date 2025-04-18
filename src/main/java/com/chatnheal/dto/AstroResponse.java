package com.chatnheal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AstroResponse {
    private String zodiacSign;
    private List<AstroMatchCompanion> companions;
}
