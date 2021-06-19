import { Router } from '@angular/router';
import { LoginKeycloakService } from './../../controllers/loginKeykloac.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  dev: string = 'CEO - Developer';

  constructor(private loginService: LoginKeycloakService, private route: Router) { }


  ngOnInit(): void {
    
  }
}
