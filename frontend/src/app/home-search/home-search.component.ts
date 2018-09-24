import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppService} from '../app-service.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-home-search',
  templateUrl: './home-search.component.html',
  styleUrls: ['./home-search.component.css']
})
export class HomeSearchComponent implements OnInit {
  places:any[]=[];
  searchText: string ;
  constructor(private http:HttpClient,private app: AppService,private sanitizer:DomSanitizer) { }
  tempRating:any ;
  ngOnInit() {
    this.http.get(this.app.base_url+"place/get-all-places")
        .subscribe( (places:any)=>this.places=places );
  }
  sanitize(url:string){
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }
  getImage(fileName) {
    return this.app.getResourceUrl(fileName);
  }
  getArray(num) {
    let arr=[];
    for(let i=1;i<=num;i++)
      arr.push(i);
    return arr;
  }
  search() {
    this.http.get(this.app.base_url+'place/search/'+this.searchText)
        .subscribe((result:any)=>{this.places=result;} );
  }
  callSearch(event) {
     this.search();
  }


}
