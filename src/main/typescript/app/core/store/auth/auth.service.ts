import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Store} from '@ngrx/store';
import {RootState} from '../index';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class AuthService {

  private authenticated$: Observable<boolean>;

  constructor(public http: Http, private store: Store<RootState>) {
    this.authenticated$ = store.select(s => s.auth.authenticated);
  }

  public isAuthenticated(): Observable<boolean> {
    return this.authenticated$;
  }

}
