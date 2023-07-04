package com.project.projectsetting2.service;

import com.project.projectsetting2.dto.ChangeUserInfoRequest;
import com.project.projectsetting2.dto.MemberJoinRequest;
import com.project.projectsetting2.entity.Member;
import com.project.projectsetting2.entity.Role;
import com.project.projectsetting2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public void join(MemberJoinRequest dto) {
        Member member = Member.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.USER.getKey())
                .build();

        memberRepository.save(member);
    }

    public void changeUserInfo(ChangeUserInfoRequest request, Principal principal) {
        Member member = memberRepository.findByUsername(principal.getName()).get();

        if (request.getNewNickname().equals("") || request.getNewNickname().isEmpty()) {
            log.info("false");
            if (passwordEncoder.matches(request.getPassword(), member.getPassword())) {
                member.setPassword(passwordEncoder.encode(request.getNewPassword()));
            }
        } else {
            log.info("true");
            if (passwordEncoder.matches(request.getPassword(), member.getPassword())) {
                member.setNickname(request.getNewNickname());
            }
        }

        memberRepository.save(member);
    }

}
