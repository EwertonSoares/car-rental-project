//package com.car.rental.project.api.utils;
//
//import java.util.logging.Logger;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//public class PasswordUtils {
//
//	private static final Logger log = (Logger) LoggerFactory.getLogger(PasswordUtils.class);
//	
//	public PasswordUtils() {
//		
//	}
//	
//	/**
//	 * Gera um hash utilizando o Bycript
//	 * 
//	 * @Param senha
//	 * @Return String
//	 */
//	public static String gerarBCrypt(String senha) {
//		if(senha == null) {
//			return senha;
//		}
//		
//		log.info("Gerando hash com o Bcrypt. ");
//		BCryptPasswordEncoder  bCriptEncoder = new BCryptPasswordEncoder();
//		return bCriptEncoder.encode(senha);
//	}
//}
