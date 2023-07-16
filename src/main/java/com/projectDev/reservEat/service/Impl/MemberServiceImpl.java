package com.projectDev.reservEat.service.Impl;

import com.projectDev.reservEat.dto.MemberDTO;
import com.projectDev.reservEat.entity.MemberEntity;
import com.projectDev.reservEat.repository.MemberRepository;
import com.projectDev.reservEat.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberDTO memberDTO){
        MemberEntity member = MemberEntity.builder()
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .password(memberDTO.getPassword())
                .build();
                return memberRepository.save(member).getId();
    }
}
