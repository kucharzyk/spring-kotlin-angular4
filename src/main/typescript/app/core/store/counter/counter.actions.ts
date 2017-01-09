import {Action} from '@ngrx/store';
import {uniqueActionType} from '../shared/unique-action-type';

export const ActionTypes = {
  INCREMENT_COUNTER: uniqueActionType('[Counter] Increment Counter'),
  DECREMENT_COUNTER: uniqueActionType('[Counter] Decrement Counter')
};

export class IncrementCounterAction implements Action {
  type = ActionTypes.INCREMENT_COUNTER;

  constructor() {
  }
}

export class DecrementCounterAction implements Action {
  type = ActionTypes.DECREMENT_COUNTER;

  constructor() {
  }
}

export type Actions
  = IncrementCounterAction
  | DecrementCounterAction;
