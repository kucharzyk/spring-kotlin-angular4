import '@ngrx/core/add/operator/select';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/let';
import {AuthState, initialState} from './auth.state';
import {Actions, ActionTypes, ProcessTokenAction, AuthErrorAction} from './auth.actions';
import {AuthService} from './auth.service';

export function authReducer(state = initialState, action: Actions): AuthState {
  switch (action.type) {

    case ActionTypes.LOGOUT:
      return Object.assign({}, initialState);

    case ActionTypes.PROCESS_TOKEN:
      const processTokenAction: ProcessTokenAction = action as ProcessTokenAction;
      const userData = AuthService.decodeAccessToken(processTokenAction.jwtToken);
      return Object.assign({}, initialState, {
        authenticated: true,
        tokenExpirationDate: new Date(userData.exp * 1000),
        userData: userData,
        jwtToken: processTokenAction.jwtToken
      });

    case ActionTypes.AUTH_ERROR:
      const authErrorAction: AuthErrorAction = action as AuthErrorAction;
      return Object.assign({}, userData, {error: authErrorAction.error});

    case ActionTypes.CLEAR_AUTH_ERROR:
      return Object.assign({}, userData, {error: null});

    default:
      return state;
  }
}

export const isAuthenticated = (state: AuthState) => state.authenticated;
