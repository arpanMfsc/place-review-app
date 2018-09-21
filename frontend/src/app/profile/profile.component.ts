import { Component, OnInit } from '@angular/core';
import {AppService} from '../app-service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  authenticated:any=false;
  constructor(private app: AppService,private router: Router,private http:HttpClient) { }

  ngOnInit() {
    this.authenticated=this.app.isAuthenticated();
    if(!this.app.isAuthenticated())
      this.router.navigate(['home/login']);
  }

}
