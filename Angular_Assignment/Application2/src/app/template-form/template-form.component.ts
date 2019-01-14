import { Component, OnInit } from '@angular/core';
import { Employee } from './EmployeeModel'
@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styleUrls: ['./template-form.component.css']
})
export class TemplateFormComponent implements OnInit {
  model:Employee=new Employee("",18,"");
  submitted:boolean=false;
  constructor() { }

  ngOnInit() {
  }
  onSubmit(){
    this.submitted=true;
  }
  get diagnostic(){return JSON.stringify(this.model);}

}
