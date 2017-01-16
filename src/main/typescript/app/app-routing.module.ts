import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {MainModule} from './main/main.module';
import {AuthModule} from './auth/auth.module';

export function loadMainModule() {
  return MainModule;
}

export function loadAuthModule() {
  return AuthModule;
}

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    loadChildren: loadMainModule
  },
  {
    path: '',
    pathMatch: 'prefix',
    loadChildren: loadAuthModule
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
