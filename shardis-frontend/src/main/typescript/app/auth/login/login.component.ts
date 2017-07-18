import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Store} from '@ngrx/store';
import {RootState} from '../../core/store/index';
import {ClearAuthErrorAction, AuthenticateAction, AuthenticateActionPayload} from '../../core/store/auth/auth.actions';

@Component({
  selector: 'shardis-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username = 'admin';
  password = 'xxxxxx';
  authError$: Observable<string | undefined>;

  constructor(private store: Store<RootState>) {
    this.authError$ = store.select(s => s.auth.error);
  }

  authenticate() {
    console.log('authenticate');
    this.store.dispatch(new ClearAuthErrorAction());
    this.store.dispatch(new AuthenticateAction(new AuthenticateActionPayload(this.username, this.password)));
  }

  ngOnInit() {
    this.store.dispatch(new ClearAuthErrorAction());
  }

}
