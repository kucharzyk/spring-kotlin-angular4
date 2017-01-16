import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthRoutingModule} from './auth-routing.module';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ForgetPassComponent} from './forgetpass/forget-pass.component';
import {ActivateComponent} from './activate/activate.component';
import {AccessDeniedComponent} from './accessdenied/access-denied.component';

@NgModule({
  imports: [
    CommonModule,
    AuthRoutingModule
  ],
  declarations: [LoginComponent, RegisterComponent, ForgetPassComponent, ActivateComponent, AccessDeniedComponent]
})
export class AuthModule {
}
