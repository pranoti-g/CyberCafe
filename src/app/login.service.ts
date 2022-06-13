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

  public timeUtilized(username:any,loginTime:any,logoutTime:any,timeUtilised:any):Observable<any>{
    console.log("In service method");
    console.log(  "username"+username+"loginTime"+loginTime+"logoutTime"+logoutTime+"timeUtilized"+timeUtilised);
    return this.http.post(this.baseurl+"timeUtilized",{
      "username":username, 
      "loginTime":loginTime,
      "logoutTime":logoutTime,
      "timeUtilized":timeUtilised
    })
  }
}
