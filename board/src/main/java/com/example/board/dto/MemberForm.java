package com.example.board.dto;

import com.example.board.entity.Members;

public class MemberForm {
    private String email;
    private String password;

    public MemberForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public Members toEntity() {
        return new Members(null, email, password);
    }
}
