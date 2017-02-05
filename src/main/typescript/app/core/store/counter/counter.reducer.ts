import '@ngrx/core/add/operator/select';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/let';
import * as counter from './counter.actions';
import {CounterState, initialCounter} from './counter.state';

export function counterReducer(state = initialCounter, action: counter.Actions): CounterState {
  switch (action.type) {
    case counter.ActionTypes.INCREMENT_COUNTER:
      return {value: state.value + 1};
    case counter.ActionTypes.DECREMENT_COUNTER:
      return {value: state.value - 1};
    default:
      return state;
  }
}

