import { Component, OnInit } from '@angular/core';
import {AppService} from '../app-service.service';
@Component({
  selector: 'user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  editable:any=false;
  model: any = {userId: this.app.user.userId,userName: "",email: "",phone: "",profession: ""}
  constructor(private app: AppService) { }

  ngOnInit() {
    this.model.userName = this.app.user.userName;
    this.model.email = this.app.user.email;
    this.model.phone = this.app.user.phone;
  }

}
