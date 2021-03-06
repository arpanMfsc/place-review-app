import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {RouterModule} from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { ProfileComponent } from './profile/profile.component';
import {HttpClientModule} from '@angular/common/http';
import { ProfileNavbarComponent } from './profile-navbar/profile-navbar.component';
import { TimelineComponent } from './timeline/timeline.component';
import { AddPlaceComponent } from './add-place/add-place.component';
import { PlacesComponent } from './places/places.component';
import { MyPlacesComponent } from './my-places/my-places.component';
import {AppService} from './app-service.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RecentComponent } from './recent/recent.component';
import { CommentComponent } from './comment/comment.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CKEditorModule } from 'ng2-ckeditor';
import { PlaceComponent } from './place/place.component';
import { HomeSearchComponent } from './home-search/home-search.component';
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import { HttpClientHeader } from './http-client.service';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrationComponent,
    NavbarComponent,
    LoginComponent,
    ProfileComponent,
    ProfileNavbarComponent,
    TimelineComponent,
    AddPlaceComponent,
    PlacesComponent,
    MyPlacesComponent,
    PageNotFoundComponent,
    RecentComponent,
    CommentComponent,
    UserDetailsComponent,
    PlaceComponent,
    HomeSearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    RouterModule.forRoot([
    {
      path: '',
      redirectTo: 'home',
      pathMatch: 'full'
    },
    {
    		path: 'home',
        component: HomeComponent,
        children: [
          {path: '',component: HomeSearchComponent},
          { path: 'registration',component: RegistrationComponent}, 
          {
            path: 'login',
            component: LoginComponent
          }
        ]
     },
     {
        path: 'profile',
        component: ProfileComponent,
        children: [
          {
            path: '',
            redirectTo: 'recent',
            pathMatch: 'full'
          },
          {
            path: 'recent',
            component: RecentComponent
          },
          {
            path: 'places',
            component: PlacesComponent
          },
          {
            path: 'timeline',
            component: TimelineComponent
          },
          {
            path: 'addPlace',
            component: AddPlaceComponent
          },
          {
            path: 'myPlaces',
            component: MyPlacesComponent
          }
        ]
      },
      {
        path: '**',
        component: PageNotFoundComponent
      }
      
    ]),
    CKEditorModule 
  ],
  providers: [AppService,HttpClientHeader],
  bootstrap: [AppComponent]
})
export class AppModule { }
