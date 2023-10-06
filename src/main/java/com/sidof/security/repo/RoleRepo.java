package com.sidof.security.repo;

import com.sidof.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author sidof
 * @Since 10/3/23
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
