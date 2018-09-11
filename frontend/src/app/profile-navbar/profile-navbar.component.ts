import { Component, OnInit } from '@angular/core';
import {AppService} from "../app-service.service";
@Component({
  selector: 'profile-navbar',
  templateUrl: './profile-navbar.component.html',
  styleUrls: ['./profile-navbar.component.css']
})
export class ProfileNavbarComponent implements OnInit {

  constructor(private app: AppService) { }

  ngOnInit() {
  }

}
