package com.example.carparkingmanagementbe.dto.ticket;

public class UpdateUserEmailDto {
    private String role;
    private String email;


    public UpdateUserEmailDto() {
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
