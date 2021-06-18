import { UsuarioBarbeiro } from './../../../models/usuarioBarbeiro';
import { ServicoService } from './../../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';
import { UsuarioBarbeiroService } from 'src/app/controllers/usuario-barbeiro.service';
import { Servico } from 'src/app/models/servico';

@Component({
  selector: 'ads-servico-list-barbeiro',
  templateUrl: './servico-list-barbeiro.component.html',
  styleUrls: ['./servico-list-barbeiro.component.css']
})
export class ServicoListBarbeiroComponent implements OnInit {

  novoservico: Servico = {
    id: '',
    nome: '',
    descricao: '',
    valor: '',
    imageUrl: '',
    usuarioBarbeiro: '',
  }



  url = ""
  servicos: any[] = []
  usuarioBarbeiro!: UsuarioBarbeiro
  constructor(private servicoService: ServicoService, private usuarioBarbeiroService: UsuarioBarbeiroService) { }

  ngOnInit(): void {
    this.setBarbeiro()
  }

  setBarbeiro() {
    this.usuarioBarbeiroService.findBarbeiroByEmail(localStorage.getItem("loginEmail")).subscribe(result => {
      this.usuarioBarbeiro = result
      this.getServicoBarbeiro(this.usuarioBarbeiro.id);
    })
  }

  getServicoBarbeiro(idBarbeiro: number) {
    this.servicoService.findServicosByBarbeiro(idBarbeiro).subscribe(result => {
      this.servicos = result
    })
  }

  update(): void {
    this.servicoService.updateServico(this.novoservico).subscribe((resposta) => {
      alert("Serviço alterado com sucesso!")
      location.reload();
    });
  }

  popularDadosModal(id: any) {
    this.servicoService.findAllServicosById(id).subscribe(resposta => this.novoservico = resposta)
  }

  deleteServico(id: any) {
    var retorno = confirm("Deseja deletar este serviço?");
    if (retorno == true) {
      alert("Serviço deletado com sucesso!")
      this.servicoService.deleteServico(id).subscribe(resposta => { location.reload() })
    }
    else {
      alert("Deleção Cancelada!")
    }

  }

  onselectFile(e: any) {
    if (e.target.files) {
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        this.url = event.target.result
        this.novoservico.imageUrl = event.target.result
        console.log(this.url)
      }
    }
  }
}
