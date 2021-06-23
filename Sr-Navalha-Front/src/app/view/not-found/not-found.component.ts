import { Router } from '@angular/router';
import { LoginKeycloakService } from './../../controllers/loginKeykloac.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css']
})
export class NotFoundComponent implements OnInit {

  constructor(private login: LoginKeycloakService,private router: Router) { }

  ngOnInit(): void {
  }

  verificar(){
    if(this.login.getIsLogged()){
      this.router.navigate(["/carregando"])
    }else{
      this.router.navigate(["/"])
    }
  }

}
