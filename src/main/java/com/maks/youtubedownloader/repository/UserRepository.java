package com.maks.youtubedownloader.repository;

import com.maks.youtubedownloader.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean findByEmail(String email);
}
