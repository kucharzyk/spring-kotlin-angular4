import {NgModule} from '@angular/core';
import {MainRoutingModule} from './main-routing.module';
import {MainViewComponent} from './main-view/main-view.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {ClarityModule} from 'clarity-angular';
import {CounterModule} from '../counter/counter.module';
import {CommonModule} from '@angular/common';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    ClarityModule.forChild(),
    MainRoutingModule,
    CounterModule
  ],
  declarations: [MainViewComponent]
})
export class MainModule {
}
