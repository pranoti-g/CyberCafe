import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { StompServiceService } from '../stomp-service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  notification:any;
  constructor(private stompService:StompServiceService,
    private adminService:AdminService) { }

  ngOnInit(): void {
    
    

    this.stompService.subscribe('/topic/request',():void=>{
      console.log("getCall")
      this.userLogout();
    })
  }


  userLogout(){
      this.adminService.userLogout().subscribe(
        data =>{
          this.notification=data.status+" user Logout";
          console.log(this.notification)

        }
      )
  }
}
