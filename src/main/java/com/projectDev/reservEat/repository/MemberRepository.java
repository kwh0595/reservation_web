package com.projectDev.reservEat.repository;

import com.projectDev.reservEat.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

}
