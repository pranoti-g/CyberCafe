import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  baseurl = "http://localhost:8081/";

  url = "";

  public login(username:any,password:any):Observable<any>{
    return this.http.post(this.baseurl+"login",{
      "username" : username,
      "password" : password
    })
  }
}
