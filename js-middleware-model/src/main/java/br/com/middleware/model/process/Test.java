package br.com.middleware.model.process;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Joel on 31/01/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Test {

    private Long id;
    private String name;
    private String lastName;
    private LocalDateTime created;
    private LocalDateTime birthday;

    public Test(){}

    public Test(Long id, String name, String lastName, LocalDateTime created, LocalDateTime birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.created = created;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
