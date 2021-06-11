import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { OAuthService } from 'angular-oauth2-oidc';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginKeycloakService {

  constructor(private oauthService: OAuthService, private route: Router) { }

  public login(): Observable<any> {
    this.oauthService.initImplicitFlowInternal();
    return new Observable;
  }

  public logout(): void {
    this.oauthService.logOut();
  }

  public getIsLogged(): boolean {
    return (this.oauthService.hasValidIdToken() && this.oauthService.hasValidAccessToken());
  }

  public getUsername(): any {
    const token = this.oauthService.getAccessToken();
    const payload = token.split('.')[1];
    const payloadDecodedJson = atob(payload);
    const payloadDecoded = JSON.parse(payloadDecodedJson);
    return payloadDecoded.preferred_username;
  }

  public getIsAdmin(): boolean {
    const token = this.oauthService.getAccessToken();
    const payload = token.split('.')[1];
    const payloadDecodedJson = atob(payload);
    const payloadDecoded = JSON.parse(payloadDecodedJson);
    localStorage.setItem("tipo", (payloadDecoded.realm_access.roles[0]));
    localStorage.setItem("loginEmail", (payloadDecoded.email));
    localStorage.setItem("preferred_username", (payloadDecoded.preferred_username));
    localStorage.setItem("name", (payloadDecoded.name));
    return payloadDecoded.realm_access.roles.indexOf('realm-admin') !== -1;
  }

  public getToken(): any {
    const token = this.oauthService.getAccessToken();
    const payload = token.split('.')[1];
    return payload;
  }

  clearLocalStorage() {
    localStorage.removeItem("preferred_username")
    localStorage.removeItem("loginEmail")
    localStorage.removeItem("access_token_ads04")
    localStorage.removeItem("name")
    localStorage.removeItem("tipo")
    localStorage.clear()
  }

  redirect(tipo: any) {
    if(tipo !== ''){
      if (this.getIsLogged()) {
        if (tipo == "cliente") {
          this.route.navigate(["/telaCliente"])
        } else if (tipo == "barbeiro") {
          this.route.navigate(["/telaBarbeiro"])
        } else {
          this.route.navigate(["/admin"])
        }
      }
    }else{
      this.clearLocalStorage()
    }
  }
}
