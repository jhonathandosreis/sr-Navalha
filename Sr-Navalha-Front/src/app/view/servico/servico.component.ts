import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { ServicoService } from '../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';
import { Servico } from 'src/app/models/servico';

@Component({
  selector: 'ads-servico',
  templateUrl: './servico.component.html',
  styleUrls: ['./servico.component.css']
})
export class ServicoComponent implements OnInit {

  url = ""
  servico: Servico = { id: 0, nome: "", descricao: "", valor: 0, imageUrl: "", usuarioBarbeiro: null };
  constructor(public serviceServico: ServicoService, private usuarioBarbeiro: UsuarioBarbeiroService) { }

  ngOnInit(): void {
    this.setBarbeiro()
  }



  createservico() {
    this.serviceServico.createServico(this.servico).subscribe(resposta => {
    this.servico = resposta
    this.setBarbeiro()
    confirm("Serviço cadastrado com sucesso!")
    location.reload()
    });
  }

  setBarbeiro() {
    this.usuarioBarbeiro.findBarbeiroByEmail(localStorage.getItem("admin-logado")).subscribe(result => {
    this.servico.usuarioBarbeiro = result
    })
  }

  onselectFile(e: any) {
    if (e.target.files) {
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        this.url = event.target.result
        this.servico.imageUrl = event.target.result
        console.log(this.url)
      }
    }
  }

}
