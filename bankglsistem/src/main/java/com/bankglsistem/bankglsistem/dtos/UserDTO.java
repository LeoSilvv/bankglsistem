package com.bankglsistem.bankglsistem.dtos;

import com.bankglsistem.bankglsistem.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
}
