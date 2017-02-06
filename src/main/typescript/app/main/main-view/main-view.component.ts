import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {RootState} from '../../core/store/index';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'shardis-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.scss']
})
export class MainViewComponent implements OnInit {

  title = 'shardis works!';
  userData$: Observable<any>;

  constructor(private store: Store<RootState>) {
    this.userData$ = store.select(s => s.auth.userData);
  }

  ngOnInit() {
  }

}
