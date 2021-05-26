import { UsuarioBarbeiro } from './../models/usuarioBarbeiro';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuarioBarbeiroService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

 
  findAllBarbeiro(): Observable<UsuarioBarbeiro[]> {
    return this.http.get<UsuarioBarbeiro[]>(`${this.baseUrl}/usuarioBarbeiro`);
  }

  createBarbeiro(usuarioBarbeiro: UsuarioBarbeiro): Observable<UsuarioBarbeiro> {
    return this.http.post<UsuarioBarbeiro>(`${this.baseUrl}/usuarioBarbeiro`, usuarioBarbeiro);
  }

  updateBarbeiro(usuarioBarbeiro: UsuarioBarbeiro): Observable<UsuarioBarbeiro> {
    return this.http.post<UsuarioBarbeiro>(`${this.baseUrl}/usuarioBarbeiro`, usuarioBarbeiro);
  }

  deleteBarbeiro(id: any): Observable<void> {
    const url = `${this.baseUrl}/usuarioBarbeiro${id}`
    return this.http.delete<void>(url);
  }

}
