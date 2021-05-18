import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  AdminNome: any;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado")
  }

  sair() {
    this.router.navigate(["/"])
    localStorage.removeItem("admin-logado")
  }

}
