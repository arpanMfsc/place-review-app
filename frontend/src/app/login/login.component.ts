import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model:any={userId: "",password: ""};
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }
  login() {
    this.http.post("http://localhost:8080/api/login",this.model)
        .subscribe((user)=>console.log(user));
  }

}
