import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {
  ActionTypes,
  AuthenticateAction,
  ProcessTokenAction,
  AuthErrorAction,
  AuthSuccessAction,
  LogoutAction,
  ClearAuthStateAction,
  LoadAndProcessTokenAction
} from './auth.actions';
import {Effect, Actions} from '@ngrx/effects';
import {Observable} from 'rxjs/Rx';
import {go} from '@ngrx/router-store';
import {LocalStorage} from 'ng2-webstorage';
import {Action} from '@ngrx/store';


@Injectable()
export class AuthEffects {

  @Effect() authenticate$: Observable<Action> = this.actions$
    .ofType(ActionTypes.AUTHENTICATE)
    .map(action => action as AuthenticateAction)
    .switchMap((action: AuthenticateAction) => {
      if (!action.payload.username.trim()) {
        return Observable.of(new AuthErrorAction('Username cannot be blank'));
      }
      if (!action.payload.password.trim()) {
        return Observable.of(new AuthErrorAction('Password cannot be blank'));
      }
      const headers = new Headers();
      headers.append('Content-Type', `application/x-www-form-urlencoded`);
      const payload = 'username=' + encodeURIComponent(action.payload.username)
        + '&password=' + encodeURIComponent(action.payload.password);
      return this.http
        .post('/api/authentication', payload, {headers: headers})
        .map(res => new AuthSuccessAction(res.text()))
        .catch(() => Observable.of(new AuthErrorAction('Authentication failed')));
    });

  @Effect() authSuccess$: Observable<Action> = this.actions$
    .ofType(ActionTypes.AUTH_SUCCESS)
    .map(action => action as AuthSuccessAction)
    .switchMap(action => {
      this.jwtToken = action.payload;
      return Observable.concat(
        Observable.of(go('/')),
        Observable.of(new ProcessTokenAction(action.payload))
      );
    });

  @Effect() logout$: Observable<Action> = this.actions$
    .ofType(ActionTypes.LOGOUT)
    .map(action => action as LogoutAction)
    .map(() => {
      this.jwtToken = null;
      return new ClearAuthStateAction();
    });

  @Effect() loadAndProcessToken$: Observable<Action> = this.actions$
    .ofType(ActionTypes.LOAD_AND_PROCESS_TOKEN)
    .map(action => action as LoadAndProcessTokenAction)
    .switchMap(() => {
      if (!!this.jwtToken) {
        return Observable.of(new ProcessTokenAction(this.jwtToken));
      } else {
        return Observable.empty();
      }
    });

  @LocalStorage('token')
  public jwtToken: string;

  constructor(private http: Http, private actions$: Actions) {
  }

}
