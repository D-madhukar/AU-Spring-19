import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit {
  employeeid:number;
  employees:Object;
  constructor(private router:ActivatedRoute,private employeeservice:EmployeeService) { 
    // this.employeeid=Number(this.router.snapshot.paramMap.get('id'));
    this.router.params.subscribe(params=>{
      this.employeeid=params.id;
    })
  }

  ngOnInit() {
    this.employeeservice.getEmployees().subscribe(data=>{
      this.employees=data;
    })
  }

}
