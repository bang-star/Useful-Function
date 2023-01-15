package com.example.controller;

import com.example.entity.Member;
import com.example.entity.StoreProduct;
import com.example.repo.MemberRepository;

import com.example.repo.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {

    @Autowired MemberRepository memberRepository;
    @Autowired StoreProductRepository storeProductRepository;

    @GetMapping("/members")
    @ResponseBody
    public List<Member> memberList(){
        return memberRepository.findAll();
    }

    @GetMapping("/stores") @ResponseBody
    public List<StoreProduct> storeProductList(){
        List<StoreProduct> storeProducts = storeProductRepository.findAll();

        for(StoreProduct storeProduct : storeProducts){
            System.out.println(storeProduct.getStore().toString());
            System.out.println(storeProduct.getProduct().toString());
        }

      return storeProducts;
    }

}
