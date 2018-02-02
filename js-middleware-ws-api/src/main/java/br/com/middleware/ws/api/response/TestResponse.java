package br.com.middleware.ws.api.response;

import java.time.LocalDate;

/**
 * Created by joel on 31/01/18.
 */
public class TestResponse {

    private Long id;
    private String fullName;
    private LocalDate birthday;

    public TestResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
