import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component'
import { TemplateFormComponent } from './template-form/template-form.component'
const routes: Routes = [
  {path:'employee' ,component:EmployeeComponent},
  {path:'employee/:id',component:EmployeeComponent},
  {path:'employeeform',component:TemplateFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
