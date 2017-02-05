import '@ngrx/core/add/operator/select';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/let';
import {AuthState, initialState} from './auth.state';
import {Actions, ActionTypes} from './auth.actions';

export function authReducer(state = initialState, action: Actions): AuthState {
  switch (action.type) {
    case ActionTypes.LOGOUT:
      return initialState;
    default:
      return state;
  }
}


export const isAuthenticated = (state: AuthState) => state.authenticated;
