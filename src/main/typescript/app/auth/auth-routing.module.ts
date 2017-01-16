import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AccessDeniedComponent} from './accessdenied/access-denied.component';
import {ForgetPassComponent} from './forgetpass/forget-pass.component';
import {RegisterComponent} from './register/register.component';

const routes: Routes = [
  {
    path: 'login',
    pathMatch: 'prefix',
    component: LoginComponent
  },
  {
    path: 'denied',
    pathMatch: 'prefix',
    component: AccessDeniedComponent
  },
  {
    path: 'forgetpass',
    pathMatch: 'prefix',
    component: ForgetPassComponent
  },
  {
    path: 'login',
    pathMatch: 'prefix',
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class AuthRoutingModule {
}
