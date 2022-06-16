import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }
  baseurl = "http://localhost:8082/";

  url = "";

  public userLogout():Observable<any>{
    return this.http.get(this.baseurl+"userLogout");
  }
}
