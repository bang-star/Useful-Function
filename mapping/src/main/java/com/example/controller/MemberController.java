package com.example.controller;

<<<<<<< Updated upstream
import com.example.mapping.entity.Member;
import com.example.mapping.repo.MemberRepository;
=======
import com.example.entity.Member;
import com.example.entity.StoreProduct;
import com.example.repo.MemberRepository;
import com.example.repo.StoreProductRepository;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes

@Controller
public class MemberController {

    @Autowired MemberRepository memberRepository;

    @GetMapping("/members")
    @ResponseBody
    public List<Member> memberList(){
        return memberRepository.findAll();
    }
<<<<<<< Updated upstream
=======

    @GetMapping("/stores") @ResponseBody
    public List<StoreProduct> productList(){
        List<StoreProduct> storeProducts = storeProductRepository.findAll();

        for(StoreProduct storeProduct : storeProducts){
            System.out.println(storeProduct.getStore().toString());
            System.out.println(storeProduct.getProduct().toString());
        }

      return storeProducts;
    }
>>>>>>> Stashed changes
}
