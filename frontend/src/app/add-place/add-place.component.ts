import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppService} from '../app-service.service';

@Component({
  selector: 'add-place',
  templateUrl: './add-place.component.html',
  styleUrls: ['./add-place.component.css']
})
export class AddPlaceComponent implements OnInit {
  model:any={name: "",description: "",address: "",pictures: ""};
  public files:any[];
  url:any="";
  public urls:any[]=[];
  constructor(private http: HttpClient,private app: AppService) { }

  ngOnInit() {
  }

  onFileChanged(event: any) {
    this.files = Array.from(event.target.files);

    this.files.forEach(file=>{
      var reader = new FileReader();

      reader.readAsDataURL(file); // read file as data url
      reader.onload = (event:any) => { // called once readAsDataURL is completed
        this.urls.push(event.target.result);
      }
    });
  
  }
  
  onUpload() {
    const formData = new FormData();
    formData.append("name",this.model.name);
    formData.append("description",this.model.description);
    formData.append("address",this.model.address);
    for (const file of this.files) {
        formData.append("file", file, file.name);
    }
    console.log(formData);
    this.http.post('http://localhost:8080/file/upload', formData).subscribe(x => console.log(x));
  }
}
