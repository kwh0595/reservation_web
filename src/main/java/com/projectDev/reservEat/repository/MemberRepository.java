package com.projectDev.reservEat.repository;

import com.projectDev.reservEat.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional; //일종의 null방지

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    //이메일로 회원 정보 조회(select from user where member_email=?)
    Optional<MemberEntity> findByEmail(String email);
}
