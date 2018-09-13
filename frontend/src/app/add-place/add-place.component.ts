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
  success:any="";
  error:any="";
  public urls:any[]=[];
  constructor(private http: HttpClient,private app: AppService) { }
 
  ngOnInit() {
  }

  onFileChanged(event: any) {
    this.files = Array.from(event.target.files);

    this.files.forEach(file=>{
      var reader = new FileReader();
      console.log(file.size);
      reader.readAsDataURL(file); // read file as data url
      reader.onload = (event:any) => { // called once readAsDataURL is completed
        this.urls.push(event.target.result);
      }
    });
  
  }
  
  onUpload() {
    const formData = new FormData();
    if(this.app.user)
      formData.append("addedBy",this.app.user.userId);
    formData.append("name",this.model.name);
    formData.append("description",this.model.description);
    formData.append("address",this.model.address);
    for (const file of this.files) {
        formData.append("file", file, file.name);
    }
    console.log(formData);
    const url=this.app.base_url+"file/upload";
    this.http.post(url, formData)
        .subscribe((x) => { 
          console.log(x);
          if(x["placeId"])
            this.success="Place added successfully, place id="+x["placeId"];

          document.getElementById("showMessage").click();

    });
  }

  onSubmit() {
    this.onUpload();
  }
}
