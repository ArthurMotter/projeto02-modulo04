import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 

import { ProfissionaisRoutingModule } from './professionals-routing.module';
import { ModalComponent } from '../layout/modal/modal.component';
import { NgxMaskDirective, NgxMaskPipe } from 'ngx-mask';
import { ProfessionalFormComponent } from './components/professional-form/professional-form.component';
import { ProfessionalListComponent } from './components/professional-list/professional-list.component';

@NgModule({
  declarations: [
    ProfessionalFormComponent,
    ProfessionalListComponent
  ],
  imports: [
    CommonModule,
    ProfissionaisRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ModalComponent ,
    NgxMaskDirective,
    NgxMaskPipe       
  ]
})
export class ProfessionalsModule { }