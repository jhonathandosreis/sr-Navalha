import { LoginKeycloakService } from './controllers/loginKeykloac.service';
import { MessageService } from './controllers/message.service';
import { Component } from '@angular/core';
import { AuthConfig, NullValidationHandler, OAuthService } from 'angular-oauth2-oidc';

@Component({
  selector: 'ads-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent {
  title = 'Sr Navalha';

  username!: any;
  isLogged!: boolean;
  isAdmin!: boolean;

  constructor(private oauthService: OAuthService,
    private messageService: MessageService,
    private loginService: LoginKeycloakService) {
    this.configure();
  }

  authConfig: AuthConfig = {
    issuer: 'http://localhost:8180/auth/realms/srnavalha',
    clientId: 'tutorial-frontend',
    responseType: 'code',
    scope: 'openid profile email',
    showDebugInformation: true,
    redirectUri: window.location.origin,
  };

  configure(): void {
    this.oauthService.configure(this.authConfig);
    this.oauthService.tokenValidationHandler = new NullValidationHandler();
    this.oauthService.setupAutomaticSilentRefresh();
    this.oauthService.loadDiscoveryDocument().then(() => this.oauthService.tryLogin())
      .then(() => {
        if (this.oauthService.getIdentityClaims()) {
          this.isLogged = this.loginService.getIsLogged();
          this.isAdmin = this.loginService.getIsAdmin();
          this.username = this.loginService.getUsername();
          this.messageService.sendMessage(this.loginService.getUsername());
        }
      });
  }

}
