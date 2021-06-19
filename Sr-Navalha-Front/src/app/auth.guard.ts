import { LoginKeycloakService } from './controllers/loginKeykloac.service';
import { Injectable } from "@angular/core";
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router, private loginService: LoginKeycloakService) { }

    canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

        const requiredRoles = next.data.requiredRoles;
        if (!this.loginService.getIsLogged()) {
            this.router.navigate(['/']);
            return false;
        }
        /*
        const realRol = this.loginService.getIsAdmin() ? 'admin' : 'user';
        if (requiredRoles.indexOf(realRol) === -1) {
            this.router.navigate(['/']);
            return false;
        } */
        return true;
    }
}