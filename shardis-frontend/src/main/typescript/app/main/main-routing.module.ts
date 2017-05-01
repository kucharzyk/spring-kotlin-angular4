import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {MainViewComponent} from './main-view/main-view.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    component: MainViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class MainRoutingModule {
}
