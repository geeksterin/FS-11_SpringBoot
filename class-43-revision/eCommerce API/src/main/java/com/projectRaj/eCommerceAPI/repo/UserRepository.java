package com.projectRaj.eCommerceAPI.repo;

import com.projectRaj.eCommerceAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
