package com.example.demo.config.security.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@NoArgsConstructor
@ToString
public class SecurityMemberVO implements UserDetails {

    private String username;
    private String password;
    private Collection<SimpleGrantedAuthority> authorities;

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean accountNonExpired; // 계정 비활성화
    private boolean accountNonLocked; // 계정 잠김 여부
    private boolean credentialsNonExpired; // 보안관련 만료(ex. password..)
    private boolean enabled; // 계정을 사용할지 여부(탈퇴..)

    public SecurityMemberVO(String username, String password, String... roles) {
        this.username = username;
        this.password = password;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;

        authorities = new ArrayList<>(roles.length);
        for (String role : roles) {
            Assert.isTrue(!role.startsWith("ROLE_"),
                    () -> role + " cannot start with ROLE_ (it is automatically added)");
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
    }
}
