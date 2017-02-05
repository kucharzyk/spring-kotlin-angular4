import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Store} from '@ngrx/store';
import {RootState} from '../index';
import {Observable} from 'rxjs/Observable';
import {LogoutAction, ProcessTokenAction, AuthErrorAction} from './auth.actions';


@Injectable()
export class AuthService {

  private authenticated$: Observable<boolean>;

  public static decodeAccessToken(access_token: string) {
    return JSON.parse(window.atob(access_token.split('.')[1]));
  }

  constructor(public http: Http, private store: Store<RootState>) {
    this.authenticated$ = store.select(s => s.auth.authenticated);
  }

  public isAuthenticated(): Observable<boolean> {
    return this.authenticated$;
  }

  public authenticate(username: string, password: string): void {

    console.log('Authentication pending...');

    if (!username.trim()) {
      this.store.dispatch(new AuthErrorAction('Username cannot be blank'));
      return;
    }
    if (!password.trim()) {
      this.store.dispatch(new AuthErrorAction('Password cannot be blank'));
      return;
    }

    const headers = new Headers();
    headers.append('Content-Type', `application/x-www-form-urlencoded`);

    const payload = 'username=' + encodeURIComponent(username) + '&password=' + encodeURIComponent(password);

    this.http
      .post('/api/authentication', payload, {headers: headers})
      .subscribe(
        data => {
          const jwtToken = data.text();
          localStorage.setItem('tokenData', jwtToken);
          this.store.dispatch(new ProcessTokenAction(jwtToken));
        },
        err => {
          console.log(err);
          this.store.dispatch(new AuthErrorAction('Username and password doesn\'t match'));
          return;
        }
      );

  }

  public logout(): void {
    localStorage.removeItem('tokenData');
    this.store.dispatch(new LogoutAction());
  }


}
