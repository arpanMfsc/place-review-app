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
  tempRating:any ;
  ngOnInit() {
    this.http.get(this.app.base_url+"place/get-all-places")
        .subscribe( (places:any)=>this.places=places );
  }
  addComment(placeId,comment,rating,index) {
    console.log(placeId,comment,rating,this.tempRating);
    this.http.post(this.app.base_url+'place/add-comment',
                    { "placeId": placeId,
                     "comment": comment,
                     "addedBy": this.app.user,
                     "rating": this.tempRating
                    } 
                  ).subscribe((comment: any)=>{
                    this.places[index].comments.push(comment)
                  });
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
}
