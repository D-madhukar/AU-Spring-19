import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employees:string[]=["Madhukar","Dileep","abhinav","sai"];
  employeecount:number=5
  constructor() { }

  ngOnInit() {
  }

}
