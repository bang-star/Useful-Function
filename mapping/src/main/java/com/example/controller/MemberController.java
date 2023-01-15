package com.example.controller;


import com.example.dto.ProductDto;
import com.example.dto.StoreProductDto;
import com.example.entity.Member;
import com.example.repo.MemberRepository;
import com.example.repo.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MemberController {

    @Autowired MemberRepository memberRepository;
    @Autowired StoreProductRepository storeProductRepository;

    @GetMapping("/members") @ResponseBody
    public List<Member> memberList(){
        return memberRepository.findAll();
    }

    @GetMapping("/members") @ResponseBody
    public List<StoreProductDto> productList(){
        return storeProductRepository.findAll().stream().map(StoreProductDto::fromEntity).collect(Collectors.toList());
    }
}
