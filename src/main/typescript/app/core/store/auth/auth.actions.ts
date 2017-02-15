import {Action} from '@ngrx/store';
import {uniqueActionType} from '../shared/unique-action-type';

export const ActionTypes = {
  AUTHENTICATE: uniqueActionType('[Auth] Authenticate'),
  AUTH_SUCCESS: uniqueActionType('[Auth] Auth success'),
  LOGOUT: uniqueActionType('[Auth] Logout'),
  LOAD_AND_PROCESS_TOKEN: uniqueActionType('[Auth] Load and process token'),
  PROCESS_TOKEN: uniqueActionType('[Auth] Process token'),
  CLEAR_AUTH_ERROR: uniqueActionType('[Auth] Clear auth error'),
  CLEAR_AUTH_STATE: uniqueActionType('[Auth] Clear auth state'),
  AUTH_ERROR: uniqueActionType('[Auth] Auth error')
};

export class AuthenticateActionPayload {

  constructor(public username: string, public password: string) {
  }

}

export class AuthenticateAction implements Action {
  type = ActionTypes.AUTHENTICATE;
  constructor(public payload: AuthenticateActionPayload) {
  }
}

export class LogoutAction implements Action {
  type = ActionTypes.LOGOUT;

  constructor() {
  }
}

export class AuthSuccessAction implements Action {
  type = ActionTypes.AUTH_SUCCESS;

  constructor(public payload: string) {
  }
}

export class LoadAndProcessTokenAction implements Action {
  type = ActionTypes.LOAD_AND_PROCESS_TOKEN;

  constructor() {
  }
}


export class ProcessTokenAction implements Action {
  type = ActionTypes.PROCESS_TOKEN;

  constructor(public payload: string) {
  }
}

export class AuthErrorAction implements Action {
  type = ActionTypes.AUTH_ERROR;

  constructor(public payload: string) {
  }
}

export class ClearAuthErrorAction implements Action {
  type = ActionTypes.CLEAR_AUTH_STATE;

  constructor() {
  }
}


export class ClearAuthStateAction implements Action {
  type = ActionTypes.CLEAR_AUTH_ERROR;

  constructor() {
  }
}


export type Actions
  = AuthenticateAction
  | AuthSuccessAction
  | LogoutAction
  | LoadAndProcessTokenAction
  | ProcessTokenAction
  | AuthErrorAction
  | ClearAuthStateAction
  | ClearAuthErrorAction;
