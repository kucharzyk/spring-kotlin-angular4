export interface AuthState {
  authenticated: boolean;
  tokenExpirationDate: Date;
  userData: any;
  jwtToken: string;
}

export const initialState: AuthState = {
  authenticated: false,
  tokenExpirationDate: null,
  userData: null,
  jwtToken: null
};


