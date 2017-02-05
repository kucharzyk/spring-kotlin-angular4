import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../core/store/auth/auth.service';
import {Observable} from 'rxjs/Observable';
import {Store} from '@ngrx/store';
import {RootState} from '../../core/store/index';

@Component({
  selector: 'shardis-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username = 'admin';
  password = 'xxxxxx';
  authError$: Observable<string>;

  constructor(private authService: AuthService, private store: Store<RootState>) {
    this.authError$ = store.select(s => s.auth.error);
  }

  authenticate() {
    console.log('authenticate');
    this.authService.authenticate(this.username, this.password);
  }

  ngOnInit() {
  }

}
