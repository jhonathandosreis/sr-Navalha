import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicoService {

  constructor(private http: HttpClient) { }

  public getServicos(): Observable<any> {
    return this.http.get(`http://localhost:8080/servicos`);
  }

  public deleteServicos(id: any): Observable<any> {
    return this.http.delete(`http://localhost:8080/servicos/${id}`);
  }

  public saveServicos(servico: { id: any; nome: any; descricao: any; valor: any; usuarioBarbeiroID: any }): Observable<any> {
    return this.http.post(`http://localhost:8080/servicos`, servico);
  }
}
