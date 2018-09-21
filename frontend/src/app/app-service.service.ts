import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { $ } from 'protractor';
import { getLocaleTimeFormat } from '@angular/common';
@Injectable({
  providedIn: 'root'
})
export class AppService {
  private MAX_SIZE = 20*1024*1024; //
  private authenticated:any=false
  public user:any={};
  public dpFile:any ;
  // specify base URL of API server here.. it can be used by other components if injected....
  public base_url="http://localhost:8080/";
  public resource_base_location = "http://localhost:80/";
  public tempDp: string ;

  constructor(private http: HttpClient) { 
  }
  authenticate() {
    this.authenticated=true;
    localStorage.setItem("token",this.user.token);
    localStorage.setItem("user",JSON.stringify(this.user));
    console.log(localStorage.getItem("user"));
  }
  isAuthenticated() {
    this.user = JSON.parse(localStorage.getItem("user"));
    return localStorage.getItem("user")!=null;
  }
  logout() {
    this.http.post(this.base_url+"api/logout",{token: localStorage.getItem("token")});
    localStorage.clear();

    this.authenticated = false;
  }
  getResourceUrl(fileName) {
    return this.resource_base_location + fileName;
  }
  onDpFileChanged(event: any) {

    this.dpFile = event.target.files[0];
    console.log(this.dpFile);
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]); // read file as data url
      reader.onload = ( (event:any) =>  // called once readAsDataURL is completed
        this.tempDp=event.target.result );
  }
  
  onDpChange() {
    console.log("working method onDpChange.");
    if(this.dpFile==null) {
      alert("plase select profile picture file");
      return;
    }
    const formData = new FormData();
    if(this.user)
      formData.append("userId",this.user.userId);
    formData.append("file", this.dpFile, this.dpFile.name);

    console.log(formData);
    const url=this.base_url+"api/change-profile-pic";
    this.http.post(url, formData)
        .subscribe((modifiedUser:any) => { this.user= modifiedUser;
        localStorage.setItem("user",JSON.stringify(modifiedUser)) } );
  }

}
