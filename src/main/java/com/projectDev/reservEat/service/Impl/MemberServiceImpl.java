package com.projectDev.reservEat.service.Impl;

import com.projectDev.reservEat.dto.MemberDTO;
import com.projectDev.reservEat.entity.MemberEntity;
import com.projectDev.reservEat.repository.MemberRepository;
import com.projectDev.reservEat.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    @Override
    public MemberDTO login(MemberDTO memberDTO) {
       /*1. 회원이 입력한 이메일로 DB에서 조회를 함
         2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
       */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByEmail(memberDTO.getEmail());
        if(byMemberEmail.isPresent()){
            //조회 결과가 있다(해당 이메일을 가진 회원 정보가 존재)
           MemberEntity memberEntity= byMemberEmail.get();
           System.out.println(byMemberEmail.get());
           if(memberEntity.getPassword().equals(memberDTO.getPassword())){
               //비밀번호 일치
               //entity -> dto 변환 후 리턴
               MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
               return dto;
           }else{
               //비밀번호 불일치(로그인 실패)
               System.out.println(MemberDTO.toMemberDTO(memberEntity));
               System.out.println("로그인 실패");
               return null;
           }
        }
        else{
            //조회 결과가 없다(해당 이메일을 가진 회원 정보가 미존재)
            System.out.println("조회된 결과가 없습니다.");
            return null;
        }
    }
}
