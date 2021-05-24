import { UsuariBarbeiro } from './../models/usuarioBarbeiro';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioBarbeiroService {

  constructor(private http: HttpClient) { }

  public getUsuarioBarbeiro(): Observable<any> {
    return this.http.get(`http://localhost:8080/servicos`);
  }

  public deleteUsuarioBarbeiro(id: any): Observable<any> {
    return this.http.delete(`http://localhost:8080/servicos/${id}`);
  }

  public saveUsuariobarbeiro(usuarioBarbeiro:UsuariBarbeiro): Observable<any> {
    return this.http.post(`http://localhost:8080/servicos`, usuarioBarbeiro);
  }

}
