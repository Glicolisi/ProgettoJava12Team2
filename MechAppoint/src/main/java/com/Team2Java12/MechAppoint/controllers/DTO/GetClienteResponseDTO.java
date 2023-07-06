package com.Team2Java12.MechAppoint.controllers.DTO;

public class GetClienteResponseDTO extends BaseResponse {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer cellulare;
    private String validation = "ACTIVE";


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

    public Integer getCellulare() {
        return cellulare;
    }

    public void setCellulare(Integer cellulare) {
        this.cellulare = cellulare;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
