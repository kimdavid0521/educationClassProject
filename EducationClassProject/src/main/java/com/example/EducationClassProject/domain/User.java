package com.example.EducationClassProject.domain;

import com.example.EducationClassProject.domain.enums.Gender;
import com.example.EducationClassProject.domain.enums.MemberStatus;
import com.example.EducationClassProject.domain.enums.Role;
import com.example.EducationClassProject.domain.enums.Verify;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, length = 20)
    private String username;

    @Enumerated(EnumType.STRING) //ordinal로 저장시 enum에 추가 변동사항이 생기면 오류가 발생할수있음
    @Column(columnDefinition = "VARCHAR(10)") //데이터 베이스에 VARCHAR타입으로 최대 10자까지 저장 가능
    private Gender gender;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 40)
    private String phone;


    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private MemberStatus memberStatus = MemberStatus.ACTIVE; // 유저 엔티티 생성시 초기값 active로 설정

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Verify verify = Verify.FALSE; // 인증 유무 초기값 false로 설정


}
