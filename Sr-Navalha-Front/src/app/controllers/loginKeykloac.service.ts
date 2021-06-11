import { Observable } from 'rxjs';
import { OAuthService } from 'angular-oauth2-oidc';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginKeycloakService {

  constructor(private oauthService: OAuthService) { }

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
}