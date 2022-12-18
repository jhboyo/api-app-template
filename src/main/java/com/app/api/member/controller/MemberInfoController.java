package com.app.api.member.controller;

import com.app.api.member.dto.MemberInfoResponseDto;
import com.app.api.member.service.MemberInfoService;
import com.app.global.resolver.memberinfo.MemberInfo;
import com.app.global.resolver.memberinfo.MemberInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberInfoController {

    private final MemberInfoService memberInfoService;
    public MemberInfoController(MemberInfoService memberInfoService) {
        this.memberInfoService = memberInfoService;
    }




    /* 아래 ResolveArguementHandler를 사용한 방식으로 변경 -> 어노테이션 생서으로 반복코드 줄임
    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(@RequestHeader("Authorization") String authorizationHeader) {

        String accessToken = authorizationHeader.split(" ")[1];
        Claims tokenClaims = tokenManager.getTokenClaims(accessToken);
        Long memberId = Long.valueOf((Integer) tokenClaims.get("memberId"));

        MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(memberId);

        return ResponseEntity.ok(memberInfoResponseDto);
    }*/

    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(@MemberInfo MemberInfoDto memberInfoDto) {

        Long memberId = memberInfoDto.getMemberId();
        MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(memberId);

        return ResponseEntity.ok(memberInfoResponseDto);
    }



}
