import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agendamento } from '../models/Agendamento';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AgendamentoService {

  constructor(private httpCliente: HttpClient) { }

  findAllAgendamentos(): Observable<Agendamento[]> {
    return this.httpCliente.get<Agendamento[]>(`${environment.baseUrl}/agendamentos`);
  }

  findAllAgendamentosById(id: number): Observable<Agendamento> {
    return this.httpCliente.get<Agendamento>(`${environment.baseUrl}/agendamentos/${id}`);
  }

  createAgendamento(agendamento: any): Observable<any> {
    return this.httpCliente.post<any>(`${environment.baseUrl}/agendamentos`, agendamento);
  }

  updateAgendamento(agendamento: Agendamento): Observable<Agendamento> {
    return this.httpCliente.put<Agendamento>(`${environment.baseUrl}/agendamentos`, agendamento);
  }

  deleteAgendamento(id: any): Observable<void> {
    return this.httpCliente.delete<void>(`${environment.baseUrl}/agendamentos/${id}`);
  }
}
