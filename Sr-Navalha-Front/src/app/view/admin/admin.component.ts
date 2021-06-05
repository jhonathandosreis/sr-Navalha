import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  AdminNome: any;
  constructor() { }

  ngOnInit(): void {
    this.AdminNome =localStorage.getItem("login")
  }

}
