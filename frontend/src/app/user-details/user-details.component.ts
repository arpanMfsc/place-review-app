import { Component, OnInit } from '@angular/core';
import {AppService} from '../app-service.service';
@Component({
  selector: 'user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  constructor(private app: AppService) { }

  ngOnInit() {
  }

}
