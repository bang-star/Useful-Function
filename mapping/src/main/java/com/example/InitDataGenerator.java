package com.example;

import com.example.entity.Member;
import com.example.entity.Product;
import com.example.entity.StoreProduct;
import com.example.entity.Team;
<<<<<<< Updated upstream
import com.example.repo.MemberRepository;
import com.example.repo.TeamRepository;
=======
import com.example.repo.*;
import com.example.entity.Store;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataGenerator implements ApplicationRunner {

    @Autowired TeamRepository teamRepository;
    @Autowired MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
<<<<<<< Updated upstream
        Team team1 = createTeam("강호동 팀");
        Team team2 = createTeam("이수근 팀");
=======
        Store store1 = createStore("스타벅스 신림점");
        Store store2 = createStore("스타벅스 서울대점");
>>>>>>> Stashed changes

        createMember("은지원", team1);
        createMember("김종민", team2);
        createMember("이승기", team1);
        createMember("MC몽", team2);
    }

    private Member createMember(String name, Team team) {
        Member member = memberRepository.findByName(name);

        if(member == null) {
            member = new Member();
            member.setName(name);
            member.setTeam(team);
            return memberRepository.save(member);
        }

        return member;
    }

    private Team createTeam(String name) {
        Team team = teamRepository.findByName(name);

        if(team == null){
            team = new Team();
            team.setName(name);
            return teamRepository.save(team);
        }

        return team;
    }
<<<<<<< Updated upstream
=======

    private Store createStore(String name) {
        Store store = storeRepository.findByName(name);

        if(store == null){
            store = new Store();
            store.setName(name);
            storeRepository.save(store);
        }

        return store;
    }

    private void createProduct(String name, Store store) {
        Product product = productRepository.findByName(name);

        if(product == null){
            product = new Product();
            product.setName(name);
        }

        Product saveProduct = productRepository.save(product);
        StoreProduct storeProduct = storeProductRepository.save(StoreProduct.of(store, saveProduct));

        saveProduct.addStoreProduct(storeProduct);
        store.addStoreProduct(storeProduct);
    }

>>>>>>> Stashed changes
}
