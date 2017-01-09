import {compose} from '@ngrx/core/compose';
import {storeFreeze} from 'ngrx-store-freeze';
import {combineReducers, ActionReducer} from '@ngrx/store';
import * as fromCounter from './counter/counter.reducer';
import {CounterState} from './counter/counter.state';
import {environment} from '../../../environments/environment';
import {createSelector} from 'reselect';
import {localStorageSync} from 'ngrx-store-localstorage';


export interface RootState {
  counter: CounterState;
}

const reducers = {
  counter: fromCounter.reducer
};

const developmentReducer: ActionReducer<RootState> = compose(
  storeFreeze,
  localStorageSync(['counter'], true),
  combineReducers)(reducers);
const productionReducer: ActionReducer<RootState> = compose(
  combineReducers
)(reducers);

export function reducer(state: any, action: any) {
  if (environment.production) {
    return productionReducer(state, action);
  } else {
    return developmentReducer(state, action);
  }
}

export const getCounterState = (state: RootState) => state.counter;
export const getCounterValue = createSelector(getCounterState, fromCounter.getValue);
