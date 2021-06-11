import { LoginKeycloakService } from './../../controllers/loginKeykloac.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit {

  constructor(private route: Router, private loginService: LoginKeycloakService) { }

  ngOnInit(): void {
    setTimeout(() => {
      if(this.loginService.getIsLogged()){
        this.loginService.redirect(localStorage.getItem('tipo'))
      }else{
        this.route.navigate(['/'])
      }
    }, 2000);
  }
}
