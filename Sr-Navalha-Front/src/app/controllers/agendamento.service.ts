import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AgendamentoService {

  constructor(private httpCliente: HttpClient) { }

  findAllAgendamentos(): Observable<any[]> {
    return this.httpCliente.get<any[]>(`${environment.baseUrl}/agendamentos`);
  }

  findAllAgendamentosById(id: number): Observable<any> {
    return this.httpCliente.get<any>(`${environment.baseUrl}/agendamentos/${id}`);
  }

  createAgendamento(agendamento: any): Observable<any> {
    return this.httpCliente.post<any>(`${environment.baseUrl}/agendamentos`, agendamento)
  }

  updateAgendamento(agendamento: any): Observable<any> {
    return this.httpCliente.put<any>(`${environment.baseUrl}/agendamentos`, agendamento);
  }

  deleteAgendamento(id: any): Observable<void> {
    return this.httpCliente.delete<void>(`${environment.baseUrl}/agendamentos/${id}`);
  }
}
