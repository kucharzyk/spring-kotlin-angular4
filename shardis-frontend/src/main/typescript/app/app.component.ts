import {Component, OnInit} from '@angular/core';
import {RootState} from './core/store/index';
import {Store} from '@ngrx/store';
import {LoadAndProcessTokenAction} from './core/store/auth/auth.actions';

@Component({
  selector: 'shardis-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(private store: Store<RootState>) {
  }

  ngOnInit() {
    this.store.dispatch(new LoadAndProcessTokenAction());
  }

}
