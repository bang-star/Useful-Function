package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // @EntityGraph은 쿼리가 수행이 될때 Lazy조회가 아니고 Eager 조회로 authorities 정보를 같이 가져온다.
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
