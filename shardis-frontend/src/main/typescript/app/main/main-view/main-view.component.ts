import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {RootState} from '../../core/store/index';
import {Observable} from 'rxjs/Observable';
import {LogoutAction} from '../../core/store/auth/auth.actions';

@Component({
  selector: 'shardis-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.scss']
})
export class MainViewComponent implements OnInit {

  title = 'shardis works!';
  authenticated$: Observable<boolean>;
  userData$: Observable<any>;

  constructor(private store: Store<RootState>) {
    this.authenticated$ = store.select(s => s.auth.authenticated);
    this.userData$ = store.select(s => s.auth.userData);
  }

  ngOnInit() {
  }

  public logout() {
    this.store.dispatch(new LogoutAction());
  }

}
