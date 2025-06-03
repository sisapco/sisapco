package co.com.sisapco.util;

import java.io.IOException;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;

public class GoogleAuthCodeInstalledApp extends AuthorizationCodeInstalledApp {
	
	public GoogleAuthCodeInstalledApp(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
        super(flow, receiver);
    }

    @Override
    public Credential authorize(String userId) throws IOException {
        try {
            Credential credential = getFlow().loadCredential(userId);
            if (credential != null
                    && (credential.getRefreshToken() != null
                    || credential.getExpiresInSeconds() == null
                    || credential.getExpiresInSeconds() > 60)) {
                return credential;
            }
            // open in browser
           /* String redirectUri = getReceiver().getRedirectUri();
            AuthorizationCodeRequestUrl authorizationUrl
                    = getFlow().newAuthorizationUrl().setRedirectUri(redirectUri);
            onAuthorization(authorizationUrl); */
            
            String redirectUri ="http://localhost:8081/Callback";
            
            // receive authorization code and exchange it for an access token
           // String code = getReceiver().waitForCode();
            String code = "4/0AfgeXvswua6vj6-QWgYgE4BURzwxgcRJtrTC3TGhPikcqTdBwWYwocCM2pMj0kRI0L02aQ";
            
            
            GoogleTokenResponse responser = new GoogleTokenResponse();
            responser.setAccessToken("ya29.a0AeTM1icnzylLkxMwvvWBpQhMYoQOIKqLSriZhaoF7-ZyAhLVOeBA2xk9i-ZFwg9LwbjNVzcI9z20w4FuIbCM91q_ohmPJatV8M8M8VMq2ksMaPBnmmlNtU6MeAHVMSeHKuZpzRks0XORU0TSew6kAQ_2X4cmaCgYKAUASARMSFQHWtWOmGj_M2Gobwu2277rc1K5PfQ0163");
            Long expiresIn=(long) 3599;
			responser.setExpiresInSeconds(expiresIn);
			responser.setRefreshToken("1//054bign33HM1DCgYIARAAGAUSNwF-L9Ir96vd5TupK5yhDXMotR-NMmGdlFILYvrURdTZy_mceakZvvuISELcIziOWn7n-3Llb3k");
			responser.setScope("https://www.googleapis.com/auth/drive");
			responser.setTokenType("Bearer");
			
            //GoogleTokenResponse response = (GoogleTokenResponse) getFlow().newTokenRequest(code).setRedirectUri(redirectUri).execute();
           // GoogleTokenResponse response = (GoogleTokenResponse) getFlow().newTokenRequest(code).setRedirectUri(redirectUri).execute();
            
            System.out.println(responser.getIdToken()); //YES, THIS IS THE ID TOKEN!!!
            // store credential and return it
            return getFlow().createAndStoreCredential(responser, userId);
        } finally {
            getReceiver().stop();
        }
    }

}
