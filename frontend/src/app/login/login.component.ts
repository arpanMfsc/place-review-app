import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {AppService} from '../app-service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model:any={userId: "",password: ""};
  error="";
  constructor(private http: HttpClient,private app: AppService,private router: Router) { }

  ngOnInit() {
    if(this.app.isAuthenticated())
      this.router.navigate(["profile"]);
  }
  login() {
    this.http.post("http://localhost:8080/api/login",this.model,{observe: 'response'})
        .subscribe((res: HttpResponse<any>)=>{
          if(res.body && res.body.userId){
            this.app.user=res.body;
            this.auth();
          }
          else{
            this.error="Wrong email/phone no or password....";
          }
          
        });
  }
  auth() {
    this.app.authenticate();
    this.router.navigate(["profile"]);
  }

}
