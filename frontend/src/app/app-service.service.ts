import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AppService {
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
  }
  isAuthenticated() {
    return this.authenticated;
  }
  logout() {
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
    const formData = new FormData();
    if(this.user)
      formData.append("userId",this.user.userId);
    formData.append("file", this.dpFile, this.dpFile.name);

    console.log(formData);
    const url=this.base_url+"api/change-profile-pic";
    this.http.post(url, formData)
        .subscribe((modifiedUser:any) => this.user= modifiedUser );
  }

}
