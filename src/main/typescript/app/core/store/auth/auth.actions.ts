import {Action} from '@ngrx/store';
import {uniqueActionType} from '../shared/unique-action-type';

export const ActionTypes = {
  LOGOUT: uniqueActionType('[Auth] Logout'),
  PROCESS_TOKEN: uniqueActionType('[Auth] Process token'),
  CLEAR_AUTH_ERROR: uniqueActionType('[Auth] Clear auth error'),
  AUTH_ERROR: uniqueActionType('[Auth] Auth error')
};

export class LogoutAction implements Action {
  type = ActionTypes.LOGOUT;

  constructor() {
  }
}

export class ProcessTokenAction implements Action {
  type = ActionTypes.PROCESS_TOKEN;

  constructor(public jwtToken: string) {
  }
}

export class AuthErrorAction implements Action {
  type = ActionTypes.AUTH_ERROR;

  constructor(public error: string) {
  }
}

export class ClearAuthErrorAction implements Action {
  type = ActionTypes.CLEAR_AUTH_ERROR;

  constructor() {
  }
}



export type Actions
  = LogoutAction
  | ProcessTokenAction
  | AuthErrorAction
  | ClearAuthErrorAction;
