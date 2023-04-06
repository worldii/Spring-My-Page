package com.jongha.mypage.domain;

import javax.persistence.*;

import com.jongha.mypage.dto.Role;
import com.sun.istack.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;


    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String username, String password, String name, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateUsername(String username) {
        this.username = username;
    }
}
