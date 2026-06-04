package com.rmro.viva.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class RegisterRequest {
    private String email;
    private String password;
    private String fName;
    private String lName;
    private String mobile;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }
    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}
