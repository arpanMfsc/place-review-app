import { Component, OnInit } from '@angular/core';
import {  Validators, FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {AppService} from '../app-service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
    model:any={  email: "",name: "",phone: "",password: "",confirmed: "" }
    loading = false;
    registered=false;
    registrationError=null;
    emailAvailable:any=true;
    phoneAvailable:any=true;
    
    constructor(private http: HttpClient,private app: AppService,private router: Router) { }
    ngOnInit() {

    }
    
    showMe() {
      console.log('blue event is working...');
    }
    checkEmailId() {
      //this method will check if the email id entered is already being used or not...
      this.http.post(this.app.base_url+'api/find-by-email',this.model.email)
          .subscribe((flag)=>{  
            this.emailAvailable=flag;
            console.log(this.emailAvailable);
      });
    }
    checkPhoneNo() {
      // this method will check if the phobe no entered is already being used or not...
      this.http.post(this.app.base_url+'api/find-by-phone',this.model.phone)
      .subscribe((flag)=>this.phoneAvailable=flag);
    }

    //this method is handling for ajax requet at form submission...
    onSubmit() {
      // this.loading = true;
      this.http.post(this.app.base_url+'/api/createUser',{
        userName: this.model.name,
        email: this.model.email,
        phone: this.model.phone,
        password: this.model.password,
        type: "normal"
      })
      .subscribe(data=> { this.registrationError="" ; this.registered=true; console.log(data) },
                 error=>{ this.registrationError=error; this.registered=false; console.log(error) }
       );
    }

}
