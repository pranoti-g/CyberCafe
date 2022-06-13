import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:any;
  password:any;
  Message:any;
  wrongCredential:boolean=false;
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  login(){
    console.log(this.username+":"+this.password);
    this.loginService.login(this.username,this.password).subscribe(
data=>{
  console.log(data);
  if(data.status == "valid-user"){
    this.wrongCredential=false;
    alert('Succefully Login');
  }if(data.status == "Incorrect credentials"){
    this.wrongCredential=true;
    this.Message ='Incorrect Credentials';
  }if(data.status == "User doesn't exist"){
    this.wrongCredential = true;
    this.Message ="User doesn't exist";
  }
}
    );
  }

}
