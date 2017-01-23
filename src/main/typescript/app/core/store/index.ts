import {compose} from '@ngrx/core/compose';
import {storeFreeze} from 'ngrx-store-freeze';
import {combineReducers, ActionReducer} from '@ngrx/store';
import * as fromCounter from './counter/counter.reducer';
import {CounterState} from './counter/counter.state';
import {environment} from '../../../environments/environment';
import {localStorageSync} from 'ngrx-store-localstorage';
import {RouterState, routerReducer} from '@ngrx/router-store';


export interface RootState {
  counter: CounterState;
  router: RouterState;
}

const reducers = {
  counter: fromCounter.reducer,
  router: routerReducer
};

const developmentReducer: ActionReducer<RootState> = compose(
  storeFreeze,
  localStorageSync(['counter'], true),
  combineReducers)(reducers);

const productionReducer: ActionReducer<RootState> = compose(combineReducers)(reducers);

export function reducer(state: any, action: any) {
  if (environment.production) {
    return productionReducer(state, action);
  } else {
    return developmentReducer(state, action);
  }
}

