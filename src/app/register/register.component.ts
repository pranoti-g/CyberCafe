import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterserviceService } from '../service/registerservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  name: any;
  email: any;
  username: any;
  password: any;

  userdetails: any;

  constructor(private router:Router, private registerservice:RegisterserviceService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.registerservice.RegisterUser(this.name,this.email,this.username,this.password)
    .subscribe(data =>{
      console.log(data);
     
    })
    this.router.navigate(['/fileupload',this.email]);
  }

}
