import { ServicoService } from '../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';
import { Servico } from 'src/app/models/servico';

@Component({
  selector: 'ads-servico',
  templateUrl: './servico.component.html',
  styleUrls: ['./servico.component.css']
})
export class ServicoComponent implements OnInit {

  imagem: any
  servico: Servico = { id: 0, nome: "", descricao: "", valor: 0, usuarioBarbeiro: null };
  constructor(public serviceServico: ServicoService) { }

  ngOnInit(): void {
  }

  createservico() {
    console.log(this.servico);
    this.serviceServico.saveServicos(this.servico).subscribe(resposta => {
      this.servico = resposta;
      console.log(this.servico)
    });
  }

  /*upload(urlImage: any) {
    let file: File = urlImage.files[0]
    let lerImagem = new FileReader();  
    lerImagem.addEventListener('load', (evento: any)=>{
      this.imagem = new ImageSnippet(event.target.result, file);
    });
  
  }*/

}
