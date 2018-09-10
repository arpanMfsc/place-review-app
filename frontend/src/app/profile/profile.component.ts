import { Component, OnInit } from '@angular/core';
import {AppService} from '../app-service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  authenticated:any=false;
  constructor(private app: AppService,private router: Router) { }

  ngOnInit() {
    this.authenticated=this.app.isAuthenticated();
    if(!this.authenticated)
      this.router.navigate(['home/login']);
  }

}
