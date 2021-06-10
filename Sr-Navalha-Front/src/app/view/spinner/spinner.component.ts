import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.route.navigate(["/"])
    }, 2000);
  }
}
