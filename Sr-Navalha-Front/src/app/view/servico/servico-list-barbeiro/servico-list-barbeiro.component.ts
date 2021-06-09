import { ServicoService } from './../../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-servico-list-barbeiro',
  templateUrl: './servico-list-barbeiro.component.html',
  styleUrls: ['./servico-list-barbeiro.component.css']
})
export class ServicoListBarbeiroComponent implements OnInit {

  servicos: any[] = []

  constructor(private servicoService: ServicoService) { }

  ngOnInit(): void {
  }

  getServicoBarbeiro(idBarbeiro: number) {
    this.servicoService.findServicosByBarbeiro(idBarbeiro).subscribe(result => this.servicos = result)
  }

}
