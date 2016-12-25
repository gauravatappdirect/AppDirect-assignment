package com.appdirect.assignment.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class UserDTO {
    private AddressDTO address;
    private String email;
    private String firstName;
    private String language;
    private String lastName;
    private String locale;
    private String openId;
    private String uuid;

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "address=" + address +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", language='" + language + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locale='" + locale + '\'' +
                ", openId='" + openId + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        return uuid != null ? uuid.equals(userDTO.uuid) : userDTO.uuid == null;

    }
}
