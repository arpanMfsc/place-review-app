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
  p: number = 1;
  places:any[]=[];
  searchText: string ;
  constructor(private http:HttpClient,private app: AppService,private sanitizer:DomSanitizer) { }
  tempRating:any ;
  ngOnInit() {
    this.http.get(this.app.base_url+"place/get-all-places",{headers: {'token':localStorage.getItem('token')}})
        .subscribe( (places:any)=>this.places=places );
  }
  addComment(placeId,comment,rating,index) {
    console.log(placeId,comment,rating,this.tempRating);
    if(comment.trim()!="")
    this.http.post(this.app.base_url+'place/add-comment',
                    { "placeId": placeId,
                     "comment": comment,
                     "addedBy": this.app.user,
                     "rating": this.tempRating
                    } 
                  ).subscribe((comment: any)=>{
                    this.places[index+this.p].comments.push(comment)
                  });
    else alert('place add some text');
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
  deleteComment(commentId,index) {
    console.log(commentId,index);
    if(confirm("Do you want to delete this comment ?"))
      this.http.post(this.app.base_url+"comment/delete-comment",{'commentId':commentId})
    .subscribe((data)=>{ console.log(data);
      this.places[index].comments = this.places[index]
                        .comments.filter(comment=>comment.commentId != commentId)
    });
  }
  search() {
    if(this.searchText!='')
    this.http.get(this.app.base_url+'place/search/'+this.searchText)
        .subscribe((result:any)=>{this.places=result;} );
    else
    this.http.get(this.app.base_url+'place/get-all-places')
        .subscribe((result:any)=>{this.places=result;} );
  }
  callSearch(event) {
     this.search();
  }

  deletePlace(placeId,index) {
    if(confirm("Are you sure want to delete this place?")) {

      this.http.post(this.app.base_url+'place/delete',placeId)
      .subscribe((reponse:any)=>{
        if(reponse.deleted)
          this.places= this.places.filter(place=>place.placeId != placeId);  
      });
    }
  }

  filterPlace(f) {
    switch(f) {
      case 1:
        this.places = this.places.sort((a,b)=> b.rating-a.rating );
        break;
      case 2:

        this.places = this.places.reverse();
        break;
    }
  }
  scroll() {
    window.scrollTo(0,0);
  }
}
