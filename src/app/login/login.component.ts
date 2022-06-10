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

  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  login(){
    console.log(this.username+":"+this.password);
    this.loginService.login(this.username,this.password).subscribe(
data=>{
  console.log(data);
  if(data.status == "valid-user"){
    alert('Succefully Login');
  }if(data.status == "Incorrect credentials"){
    alert('Incorrect credentials');
  }if(data.status == "User doesn't exist"){
    alert("User doesn't exist");
  }
}
    );
  }

}