import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {RouterModule} from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { ProfileComponent } from './profile/profile.component';
import {HttpClientModule} from '@angular/common/http';
import { ProfileNavbarComponent } from './profile-navbar/profile-navbar.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrationComponent,
    NavbarComponent,
    LoginComponent,
    ProfileComponent,
    ProfileNavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
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
          {
            path: 'registration',
            component: RegistrationComponent
          }, 
          {
            path: 'login',
            component: LoginComponent
          }
        ]
    	},
     {
        path: 'profile',
        component: ProfileComponent
      },
      
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
