import {Injectable} from '@angular/core';
import {HttpClient , HttpHeaders} from '@angular/common/http';
/**
 * This class changes default http response and sets header
 */
@Injectable()
export class HttpClientHeader {

  constructor(private http: HttpClient) {}

  createAuthorizationHeader(headers: HttpHeaders) {
    headers.append('token',"token"); 
  }

  get(url) {
    let headers=new HttpHeaders().append('token',localStorage.getItem('token'));

    return this.http.get(url, {
      headers: headers
    });
  }

  post(url, data) {
    let headers=new HttpHeaders().append('token',localStorage.getItem('token'));
    return this.http.post(url, data, {
      headers: headers
    });
  }
}