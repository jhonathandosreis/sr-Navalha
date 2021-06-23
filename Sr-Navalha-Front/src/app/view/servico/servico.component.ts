import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { ServicoService } from '../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';
import { Servico } from 'src/app/models/servico';
import swal from 'sweetalert';

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
    swal({title:"Serviço cadastrado com sucesso!", icon:"success"})
    location.reload
    
    });
  }

  checkCreate(){
    if( this.servico.nome == "" ) {
      swal({title:"Insira o nome do serviço!", icon: "error" })
    } else if( this.servico.descricao == "" ) {
      swal({title:"Insira a descrição do serviço!", icon: "error" })
    } else if( this.servico.imageUrl=="" ) {
      swal({title:"Insira a imagem do serviço!", icon: "error" })
    } else if( this.servico.valor <0 ) {
      swal({title:"Valor do serviço não pode ser negativo!", icon: "error" })
    } else {
      this.createservico()
    }
  }

  setBarbeiro() {
    this.usuarioBarbeiro.findBarbeiroByEmail(localStorage.getItem("loginEmail")).subscribe(result => {
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
      }
    }
  }

}
