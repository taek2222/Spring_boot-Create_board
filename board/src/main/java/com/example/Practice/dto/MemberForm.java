package com.example.Practice.dto;

import com.example.Practice.entity.Members;

public class MemberForm {
    private Long id;
    private String email;
    private String password;

    public MemberForm(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberForm{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Members toEntity() {
        return new Members(id, email, password);
    }
}
