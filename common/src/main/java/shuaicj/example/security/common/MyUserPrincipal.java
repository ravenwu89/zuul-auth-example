package shuaicj.example.security.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import shuaicj.example.security.model.Privilege;
import shuaicj.example.security.model.Role;
import shuaicj.example.security.model.User;

public class MyUserPrincipal implements UserDetails {
    private User user;
 
    public MyUserPrincipal(User user) {
        this.user = user;
    }
    
    private List<String> getPrivileges(Collection<Role> roles) {
    	List<String> privileges = new ArrayList<>();
    	List<Privilege> collection = new ArrayList<>();
    	for (Role role : roles) {
    		collection.addAll(role.getPrivileges());
    	}
    	for (Privilege item : collection) {
    		privileges.add(item.getName());
    	}
    	return privileges;
	}

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	for (String privilege : privileges) {
    	authorities.add(new SimpleGrantedAuthority(privilege));
    	}
    	return authorities;
    }
    

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getGrantedAuthorities(getPrivileges(user.getRoles()));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}