import { Component, OnInit } from '@angular/core';
import {AppService} from "../app-service.service";
import { Router } from '@angular/router';
@Component({
  selector: 'profile-navbar',
  templateUrl: './profile-navbar.component.html',
  styleUrls: ['./profile-navbar.component.css']
})
export class ProfileNavbarComponent implements OnInit {

  constructor(private app: AppService,private router:Router) { }

  ngOnInit() {
  }

}
