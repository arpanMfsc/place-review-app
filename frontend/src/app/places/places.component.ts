import { Component, OnInit } from '@angular/core';
import {AppService} from '../app-service.service';
import {HttpClient} from '@angular/common/http';
import {DomSanitizer} from '@angular/platform-browser';
@Component({
  selector: 'places',
  templateUrl: './places.component.html',
  styleUrls: ['./places.component.css']
})
export class PlacesComponent implements OnInit {

  places:any[]=[];
  constructor(private http:HttpClient,private app: AppService,private sanitizer:DomSanitizer) { }

  ngOnInit() {
    this.http.get(this.app.base_url+"place/get-all-places")
        .subscribe( (places:any)=>this.places=places );
  }
  addComment(placeId,comment,rating) {
    console.log(placeId,comment,rating);
  }
  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }
  getImage(fileName) {
    console.log(fileName);
  }
}
