package com.vcoding.financetracker.common.dto;

import java.util.Map;

public record ErrorResponse(String message, Map<String, String> errors) {}
