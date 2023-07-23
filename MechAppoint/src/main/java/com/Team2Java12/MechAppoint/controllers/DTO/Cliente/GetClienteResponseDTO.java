package com.Team2Java12.MechAppoint.controllers.DTO.Cliente;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;

public class GetClienteResponseDTO extends BaseResponse {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String cellulare;

    public GetClienteResponseDTO(Integer id, String username, String password, String email, String cellulare) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cellulare = cellulare;

    }

    public GetClienteResponseDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
