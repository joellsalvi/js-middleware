package br.com.middleware.ws.api.response;

import java.time.LocalDate;

/**
 * Created by joel on 31/01/18.
 */
public class TestResponse {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthday;

    public TestResponse() {
    }

    public TestResponse(Long id, String name, String lastName, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
