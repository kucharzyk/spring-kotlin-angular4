import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CounterRoutingModule} from './counter-routing.module';
import { CounterComponent } from './counter/counter.component';
import { CounterPageComponent } from './counter-page/counter-page.component';

@NgModule({
  imports: [
    CommonModule,
    CounterRoutingModule
  ],
  declarations: [CounterComponent, CounterPageComponent],
  exports: [CounterComponent, CounterPageComponent]
})
export class CounterModule { }
