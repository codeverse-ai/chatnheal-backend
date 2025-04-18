package com.chatnheal.dto;

import lombok.Data;

import java.util.List;

@Data
public class AstroResponse {
    private String zodiacSign;
    private List<AstroMatchCompanion> companions;
}
