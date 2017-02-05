import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CounterComponent} from './counter/counter.component';
import {CounterPageComponent} from './counter-page/counter-page.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CounterComponent, CounterPageComponent],
  exports: [CounterComponent, CounterPageComponent]
})
export class CounterModule {
}
