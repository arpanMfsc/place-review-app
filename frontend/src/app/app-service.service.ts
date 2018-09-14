import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AppService {
  private authenticated:any=false
  public user:any={};
  
  // specify base URL of API server here.. it can be used by other components if injected....
  public base_url="http://localhost:8080/";
  public resource_base_location = "http://localhost:80/";
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
}
