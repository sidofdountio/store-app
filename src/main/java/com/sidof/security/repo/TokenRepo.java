package com.sidof.security.repo;

import com.sidof.security.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author sidof
 * @Since 11/10/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Repository
public interface TokenRepo extends JpaRepository<Token, Integer> {
    @Query("""
            SELECT t FROM Token t inner join Appuser u ON t.appuser.id = u.id
             WHERE u.id = :id AND (t.expired = false OR t.revoked = false)
            """
    )
    List<Token> findAllValidTokensByAppuser(Integer id);

    Optional<Token> findByToken(String token);
}
