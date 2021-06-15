import { LoginKeycloakService } from './controllers/loginKeykloac.service';
import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor,
    HttpErrorResponse
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {


    private naoAutenticar = ["http://localhost:8080/servicos","http://localhost:4200/cadastro"];

    constructor(private router: Router, private loginService: LoginKeycloakService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
       
        let token = localStorage.getItem('access_token_ads04');
        
        if (!this.naoAutenticar.includes(request.url) && token != null) {
            request = request.clone({
                setHeaders: {
                    'Content-Type': 'application/json',
                    Authorization: `bearer ${token}`
                }
            });
        }
        return next.handle(request).pipe(tap(() => { },
            (err: any) => {
                if (err instanceof HttpErrorResponse) {
                    if (err.status === 401) {
                        alert('Erro na autenticação! Forneça usuario e senha validos!')
                        localStorage.removeItem('access_token_ads04');
                        this.router.navigate(['/']);
                    }
                    
                }
            }));
    }

}