import { Component, OnInit } from '@angular/core';
import { AppService } from '../app-service.service';
import { HttpClientHeader } from '../http-client.service';

@Component({
  selector: 'app-my-places',
  templateUrl: './my-places.component.html',
  styleUrls: ['./my-places.component.css']
})
export class MyPlacesComponent implements OnInit {

  places:any=[];
  constructor(private app: AppService,private http: HttpClientHeader) { }

  ngOnInit() {
    this.http.post(this.app.base_url+'place/place-added-by',this.app.user.userId)
    .subscribe((data:any)=>{
      this.places = data;
    });
  }

}
