import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { not } from '@angular/compiler/src/output/output_ast';

@Injectable({
  providedIn: 'root'
})
export class ConsultaCepService {

  constructor(private httpCliente: HttpClient) { }

  setHeaders = {
    'Content-Type': 'application/json',
    Authorization: ''
}

  consultaCEP(cep: string): Observable<any> {
    console.log(cep);
    cep = cep.replace(/\D/g, '');
    if (cep !== '') {
      const validacep = /^[0-9]{8}$/;
      if (validacep.test(cep)) {
        return this.httpCliente.get<any>(`//viacep.com.br/ws/${cep}/json`);
      }
    }
    return of({})
  }
}
