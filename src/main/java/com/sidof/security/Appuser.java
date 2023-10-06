package com.sidof.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

/**
 * @Author sidof
 * @Since 10/2/23
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Appuser implements UserDetails {
    @SequenceGenerator(name = "sequence_id_appuser",allocationSize = 1,sequenceName = "sequence_id_appuser") @GeneratedValue(strategy = SEQUENCE,generator = "sequence_id_appuser")
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean enable=true;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<Role>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         getRoles().forEach(role -> {
             authorities.add(new SimpleGrantedAuthority(role.getName())) ;
         });
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
