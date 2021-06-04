import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService implements Resolve<any> {

  constructor(private http: HttpClient) { }

  post(user: any, password: any): Observable<any> {
    return this.http.post(`${environment.urlLogin}/token`, { 'user': user, 'password': password });
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):
    Promise<any> | Observable<any> | any {
  }
}
