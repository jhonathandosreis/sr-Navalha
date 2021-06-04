import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servico } from '../models/servico';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServicoService {

  constructor(private httpCliente: HttpClient) { }

  findAllServicos(): Observable<Servico[]> {
    return this.httpCliente.get<Servico[]>(`${environment.baseUrl}/servicos`);
  }

  findAllServicosById(id: number): Observable<Servico> {
    return this.httpCliente.get<Servico>(`${environment.baseUrl}/servicos/${id}`);
  }

  createServico(servico: any): Observable<any> {
    return this.httpCliente.post<any>(`${environment.baseUrl}/servicos`, servico);
  }

  updateServico(servico: Servico): Observable<Servico> {
    return this.httpCliente.put<Servico>(`${environment.baseUrl}/servicos`, servico);
  }

  deleteServico(id: any): Observable<void> {
    return this.httpCliente.delete<void>(`${environment.baseUrl}/servicos/${id}`);
  }
}
