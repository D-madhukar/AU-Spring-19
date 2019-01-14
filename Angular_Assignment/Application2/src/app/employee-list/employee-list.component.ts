import { Component, OnInit, Input } from '@angular/core';
import { EmployeeService } from '../employee.service'
import { Router } from '@angular/router'

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  @Input()
  employees:string[];
  @Input()
  employeecount:number;
  users:Object;

  constructor(private employeeservice:EmployeeService,private router:Router) { }

  ngOnInit() {
    this.employeeservice.getEmployees().subscribe(data=>{
      this.users=data;
    });
  }
  onClick(employee){
    this.router.navigate(['/employee',employee.id]);
  }

}
