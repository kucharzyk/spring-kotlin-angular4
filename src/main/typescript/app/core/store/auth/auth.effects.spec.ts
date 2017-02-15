import {Http, BaseRequestOptions, ConnectionBackend, RequestOptions} from '@angular/http';
import {MockBackend} from '@angular/http/testing';
import {AuthEffects} from './auth.effects';
import {EffectsTestingModule, EffectsRunner} from '@ngrx/effects/testing';
import {LogoutAction, ActionTypes, LoadAndProcessTokenAction, AuthSuccessAction} from './auth.actions';
import {TestBed, inject} from '@angular/core/testing';
import {routerActions} from '@ngrx/router-store';


describe('Effects: Auth', () => {

  let runner: EffectsRunner = null;
  let authEffects: AuthEffects = null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        EffectsTestingModule
      ],
      providers: [
        BaseRequestOptions,
        MockBackend,
        {
          provide: Http,
          useFactory: function (backend: ConnectionBackend, defaultOptions: RequestOptions) {
            return new Http(backend, defaultOptions);
          },
          deps: [MockBackend, BaseRequestOptions]
        },
        AuthEffects
      ]
    });
  });

  beforeEach(inject([EffectsRunner, AuthEffects], (_runner: EffectsRunner, _authEffects: AuthEffects) => {
      runner = _runner;
      authEffects = _authEffects;
      _authEffects.jwtToken = null;
    }
  ));

  it('should exist', inject([AuthEffects], (service: AuthEffects) => {
    expect(service).toBeTruthy();
  }));

  it('should return a CLEAR_AUTH_STATE action after logging out', () => {
    runner.queue(new LogoutAction());

    authEffects.logout$.subscribe(result => {
      expect(result.type).toEqual(ActionTypes.CLEAR_AUTH_STATE);
    });

  });

  it('should return a PROCESS_TOKEN action after LoadAndProcessTokenAction when token is set', () => {
    authEffects.jwtToken = 'NON_EMPTY';
    runner.queue(new LoadAndProcessTokenAction());
    authEffects.loadAndProcessToken$.subscribe(result => {
      expect(result.type).toEqual(ActionTypes.PROCESS_TOKEN);
    });
  });

  it('should return a no action after LoadAndProcessTokenAction when token is not set', () => {
    authEffects.jwtToken = null;
    runner.queue(new LoadAndProcessTokenAction());

    authEffects.loadAndProcessToken$.subscribe(result => {
      expect(result).toBeFalsy();
      expect(result).toBeTruthy();
    });
  });

  it('should return actions after auth success', () => {
    authEffects.jwtToken = null;
    runner.queue(new AuthSuccessAction('TOKEN'));
    let eventCount = 0;
    authEffects.authSuccess$.subscribe(result => {
      eventCount++;
      if (eventCount === 1) {
        expect(result.type).toEqual(routerActions.GO);
      }

      if (eventCount === 2) {
        expect(result.type).toEqual(ActionTypes.PROCESS_TOKEN);
      }

    });
  });


});
