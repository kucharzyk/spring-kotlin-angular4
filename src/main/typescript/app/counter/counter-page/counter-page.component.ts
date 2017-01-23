import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import * as fromRoot from '../../core/store';
import * as counter from '../../core/store/counter/counter.actions';
import {Observable} from 'rxjs/Observable';


@Component({
  selector: 'shardis-counter-page',
  templateUrl: './counter-page.component.html',
  styleUrls: ['./counter-page.component.scss']
})
export class CounterPageComponent implements OnInit {

  value$: Observable<number>;

  constructor(private store: Store<fromRoot.RootState>) {
    this.value$ = store.select(s => s.counter.value);
  }

  increment() {
    this.store.dispatch(new counter.IncrementCounterAction());
  }

  decrement() {
    this.store.dispatch(new counter.DecrementCounterAction());
  }

  ngOnInit() {
  }

}
