import { Component, OnInit } from '@angular/core';

import { ToastrService } from 'ngx-toastr';
import { AdminService } from '../admin.service';
import { StompServiceService } from '../stomp-service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  userDetails:any;
  constructor(private stompService:StompServiceService,
    private adminService:AdminService,
    private toastr: ToastrService
) { }

  ngOnInit(): void {
    this.stompService.subscribe('/topic/request',():void=>{
      console.log("getCall")
      this.userLogout();
      this.getUserDetails();
    })

    this.getUserDetails();
  }


  userLogout(){
      this.adminService.userLogout().subscribe(
        data =>{
         this.toastr.success(data.status+" Logout");
        

        }
      )
  }

  getUserDetails(){
    this.adminService.getUserDetails().subscribe(
      data =>{
        this.userDetails=data;
      }
    )
  }
}
