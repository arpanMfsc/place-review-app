import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {AppService} from '../app-service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model:any={userId: "",password: ""};
  constructor(private http: HttpClient,private app: AppService,private router: Router) { }

  ngOnInit() {
  }
  login() {
    this.http.post("http://localhost:8080/api/login",this.model)
        .subscribe((user)=>console.log(user));
  }
  auth() {
    this.app.authenticate();
    this.router.navigate(["profile"]);
  }

}
