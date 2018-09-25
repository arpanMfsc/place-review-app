import { Component, OnInit } from '@angular/core';
import {AppService} from '../app-service.service';
import { HttpClientHeader } from '../http-client.service';

@Component({
  selector: 'user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  editable:any=false;
  model: any ;
  error:any= '';
  constructor(private app: AppService,private http: HttpClientHeader) { }

  ngOnInit() {
    this.model=this.app.user;
  }

  modifyUser() {
    console.log(this.model);
   
    this.http.post(this.app.base_url+'api/edit-user',this.model
                  )
    .subscribe((res:any)=>{ 
      if(res.error)
        alert(res.error)
      if(res.success)
        alert(res.success);
    });
  }
}
