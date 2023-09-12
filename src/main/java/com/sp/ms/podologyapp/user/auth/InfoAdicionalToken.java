package com.sp.ms.podologyapp.user.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.sp.ms.podologyapp.user.business.UserService;
import com.sp.ms.podologyapp.user.model.db.Usuario;


@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private UserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Usuario usuario = userService.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
		
		info.put("nombre", usuario.getName());
		info.put("apellido", usuario.getLastName());
		info.put("email", usuario.getEmail());
		info.put("idUsuario", usuario.getIdUser());
		info.put("rol", usuario.getRoleUser().getRoleDescription().trim());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
