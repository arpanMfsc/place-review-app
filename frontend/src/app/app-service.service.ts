import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private authenticated:any=false
  public user:any={};
  
  // specify base URL of API server here.. it can be used by other components if injected....
  public base_url="http://localhost:8080/";
  constructor() { }
  authenticate() {
    this.authenticated=true;
  }
  isAuthenticated() {
    return this.authenticated;
  }
  logout() {
    this.authenticated = false;
  }
}
