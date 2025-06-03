package co.com.sisapco.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassCryptFormulario {
	
	public static String passwordEncoder(String passFormulario) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        String pass = "";
        //El String que mandamos al metodo encode es el password que queremos encriptar.
        pass = bCryptPasswordEncoder.encode(passFormulario);
        return pass;
    }

}
