package com.example.kms_poltekastra_be.model.return_type.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {

    private String RoleID;

    private String Role;

    private String Nama;

    public Login() {
    }

    public Login(String RoleID, String Role, String Nama) {
        this.RoleID = RoleID;
        this.Role = Role;
        this.Nama = Nama;
    }

    @JsonProperty("RoleID")
    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String roleID) {
        RoleID = roleID;
    }

    @JsonProperty("Role")
    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @JsonProperty("Nama")
    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
