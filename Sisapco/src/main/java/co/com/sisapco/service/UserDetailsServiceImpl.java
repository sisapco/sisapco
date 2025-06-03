package co.com.sisapco.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.sisapco.repository.UserRepository;

import co.com.sisapco.entity.Perfil;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userrepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		co.com.sisapco.entity.Usuarios appUser = userrepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));
		
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>(); 
		
		for (Perfil perfil: appUser.getPerfiles()) {
			
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perfil.getPerNombrePerfil());
            grantList.add(grantedAuthority);
			
		}
		
		UserDetails user = (UserDetails) new User(username,appUser.getUsuClave(),grantList);
			
		
		
		return user;
	}
	
	

}
