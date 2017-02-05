import {Action} from '@ngrx/store';
import {uniqueActionType} from '../shared/unique-action-type';

export const ActionTypes = {
  LOGOUT: uniqueActionType('[Auth] Logout'),
};

export class LogoutAction implements Action {
  type = ActionTypes.LOGOUT;

  constructor() {
  }
}


export type Actions
  = LogoutAction;
