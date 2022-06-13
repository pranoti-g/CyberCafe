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

  public saveLoginTime(username:any,loginTime:any):Observable<any>{
    return this.http.post(this.baseurl+"saveLoginTime",{
      "username":username, 
      "loginTime":loginTime     
    })
  }

  public timeUtilized(username:any,logoutTime:any,timeUtilised:any):Observable<any>{
    console.log(  "username"+username+"logoutTime"+logoutTime+"timeUtilized"+timeUtilised);
    return this.http.put(this.baseurl+"timeUtilized",{
      "username":username, 
      "logoutTime":logoutTime,
      "timeUtilized":timeUtilised
    })
  }
}
