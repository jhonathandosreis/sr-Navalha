import { NavService } from './../../../controllers/nav.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-headerMaterial',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderMaterialComponent implements OnInit {
  
  constructor(
    private navService: NavService) { }

  ngOnInit(): void {}

  toggle(){
    this.navService.toggle();
  }

}
