export interface AuthState {
  authenticated: boolean;
  tokenExpirationDate?: Date;
  userData?: any;
  jwtToken?: string;
  error?: string;
}

export const initialState: AuthState = {
  authenticated: false,
  tokenExpirationDate: undefined,
  userData: undefined,
  jwtToken: undefined,
  error: undefined
};


